package com.jain.mayank.service;

import java.util.Stack;

/**
 * The XmlValidatorService class provides methods for validating XML strings.
 */
public class XmlValidatorService {

    /**
     * Checks if given XML string is valid.
     *
     * @param xmlString The XML string to be validated.
     * @return true if XML string is valid, otherwise false.
     */
    public boolean DetermineXml(String xmlString) {

        // Stack to keep track of opening tags
        Stack<String> stringPool = new Stack<>();

        // Check for basic XML structure before proceeding
        if ((xmlString == null) || (xmlString.isEmpty()) ||
                (xmlString.charAt(0) != '<') || (xmlString.charAt(xmlString.length() - 1) != '>')) {
            return false;
        }

        // Iterate through each character in XML string
        for (int i = 0; i < xmlString.length(); i++) {

            // Check for closing tags
            if (xmlString.charAt(i) == '<' && xmlString.charAt(i + 1) == '/') {
                // Extract the tag from closing tag and add to stack
                i = extractStringFromTags(xmlString, i + 2, stringPool);

                // Validate the XML structure for extracted closing tag
                if (!validateXML(stringPool)) {
                    return false;
                }
            } else if (xmlString.charAt(i) == '<') {
                // Check for opening tags and extract the tag and add to stack
                i = extractStringFromTags(xmlString, i + 1, stringPool);
            }
        }
        // If the stack is empty, all opening tags have a corresponding closing tag
        return stringPool.isEmpty();
    }

    /**
     * Validates the XML structure by comparing opening and closing tags.
     *
     * @param stringPool The stack containing opening tags.
     * @return true if the XML structure is valid, otherwise false.
     */
    private boolean validateXML(Stack<String> stringPool) {
        if (stringPool.size() < 2) {
            // If there are not enough tags in the stack, the structure is invalid
            return false;
        }
        String endingTag = stringPool.pop();
        String startingTag = stringPool.pop();
        return startingTag.equals(endingTag);
    }

    /**
     * Extracts the tag from opening or closing tags.
     *
     * @param xmlString  The XML string containing tags.
     * @param i          The current index in the XML string.
     * @param stringPool The stack to store the extracted tags.
     * @return The updated index after extracting the tag.
     */
    private int extractStringFromTags(String xmlString, int i, Stack<String> stringPool) {

        StringBuilder extractedString = new StringBuilder();

        // Extract characters until the '>' is encountered
        while (i < xmlString.length() && xmlString.charAt(i) != '>') {
            extractedString.append(xmlString.charAt(i));
            i++;
        }

        // Push the extracted tag onto the stack
        stringPool.push(String.valueOf(extractedString));
        return i;
    }
}