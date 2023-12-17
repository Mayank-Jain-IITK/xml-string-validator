package com.jain.mayank;

import com.jain.mayank.service.XmlValidatorService;

public class Main {
    public static void main(String[] args) {

        // Create instance of XmlValidatorService
        XmlValidatorService xmlValidatorService = new XmlValidatorService();

        // Sample XML string
        String xmlString = "<abc><def>validString</def></abc>";
        System.out.println("Given String: " + xmlString + "\nIs it a valid XML string: " + xmlValidatorService.DetermineXml(xmlString));

    }
}
