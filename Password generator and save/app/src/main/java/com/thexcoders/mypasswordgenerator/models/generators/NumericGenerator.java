package com.thexcoders.mypasswordgenerator.models.generators;

import com.thexcoders.mypasswordgenerator.models.helpers.Helper;

public class NumericGenerator extends PasswordGenerator{
    private static final char CHAR_0 = '0';
    private static final char CHAR_9 = '9';


    @Override
    public String getChar() {
        return String.valueOf((char) (Helper.randomChar(CHAR_0, CHAR_9)));
    }
}
