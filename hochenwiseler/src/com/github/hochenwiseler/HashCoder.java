/*
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *                    Version 2, December 2004
 *
 * Copyright (C) 2013 Wolf Posdorfer
 *
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 *
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 *  0. You just DO WHAT THE FUCK YOU WANT TO.
 *
 */
package com.github.hochenwiseler;

public class HashCoder
{

    public static int getHashCode(char... charArr)
    {
        int h = 0;

        for (int i = 0; i < charArr.length; i++)
        {
            h = 31 * h + charArr[i];
        }

        return h;
    }

    public static int getHashCode(int hashcodeOfFirstString, String secondString)
    {
        int h = hashcodeOfFirstString;

        for (int i = 0; i < secondString.length(); i++)
        {
            h = 31 * h + secondString.charAt(i);
        }

        return h;
    }

}
