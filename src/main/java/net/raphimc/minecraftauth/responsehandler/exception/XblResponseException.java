/*
 * This file is part of MinecraftAuth - https://github.com/RaphiMC/MinecraftAuth
 * Copyright (C) 2023 RK_01/RaphiMC and contributors
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.raphimc.minecraftauth.responsehandler.exception;

import lombok.Getter;
import org.apache.http.client.HttpResponseException;

import java.util.HashMap;
import java.util.Map;

@Getter
public class XblResponseException extends HttpResponseException {

    public static final Map<Long, String> ERROR_CODES = new HashMap<>();

    static {
        ERROR_CODES.put(2148916227L, "Your account was banned by Xbox for violating one or more Community Standards for Xbox and is unable to be used.");
        ERROR_CODES.put(2148916229L, "Your account is currently restricted and your guardian has not given you permission to play online. Login to https://account.microsoft.com/family/ and have your guardian change your permissions.");
        ERROR_CODES.put(2148916233L, "Your account currently does not have an Xbox profile. Please create one at https://signup.live.com/signup");
        ERROR_CODES.put(2148916234L, "Your account has not accepted Xbox's Terms of Service. Please login and accept them.");
        ERROR_CODES.put(2148916235L, "Your account resides in a region that Xbox has not authorized use from. Xbox has blocked your attempt at logging in.");
        ERROR_CODES.put(2148916236L, "Your account requires proof of age. Please login to https://login.live.com/login.srf and provide proof of age.");
        ERROR_CODES.put(2148916237L, "Your account has reached the its limit for playtime. Your account has been blocked from logging in.");
        ERROR_CODES.put(2148916238L, "The account date of birth is under 18 years and cannot proceed unless the account is added to a family by an adult.");
    }

    private final long xblErrorCode;

    public XblResponseException(final int statusCode, final long xblErrorCode, final String reasonPhrase) {
        super(statusCode, reasonPhrase + ", xbox live error code: " + xblErrorCode);

        this.xblErrorCode = xblErrorCode;
    }

}
