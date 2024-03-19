package com.thexcoders.mypasswordgenerator.models.generators;

import com.thexcoders.mypasswordgenerator.models.helpers.Helper;

public class UpperCaseGenerator extends PasswordGenerator{
    private static final char CHAR_A = 'A';
    private static final char CHAR_Z = 'Z';


    @Override
    public String getChar() {
        return String.valueOf((char) (Helper.randomChar(CHAR_A,CHAR_Z)));
    }
}
