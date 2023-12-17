package com.jain.mayank.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class XmlValidatorServiceTest {

    private XmlValidatorService xmlValidatorService;

    @Before
    public void setUp() {
        xmlValidatorService = new XmlValidatorService();
    }

    // Test case for a valid XML scenario
    @Test
    public void testValidXmlScenario1() {
        String validXml = "<Design><Code>hello world</Code></Design>";
        assertTrue(xmlValidatorService.DetermineXml(validXml));
    }

    // Test case for an invalid XML scenario with missing closing tag
    @Test
    public void testInvalidXmlScenario1() {
        String invalidXml = "<Design><Code>hello world</Code></Design><People>";
        assertFalse(xmlValidatorService.DetermineXml(invalidXml));
    }

    // Test case for an invalid XML scenario with mismatched closing tag
    @Test
    public void testInvalidXmlScenario2() {
        String invalidXml = "<People><Design><Code>hello world</People></Code></Design>";
        assertFalse(xmlValidatorService.DetermineXml(invalidXml));
    }

    // Test case for an invalid XML scenario with mismatched quotes in attribute
    @Test
    public void testInvalidXmlScenario3() {
        String invalidXml = "<People age=”1”>hello world</People>";
        assertFalse(xmlValidatorService.DetermineXml(invalidXml));
    }

    // Test case for a valid XML scenario with nested elements
    @Test
    public void testValidXmlScenario2() {
        String validXml = "<root><element1>value1</element1><element2>value2</element2></root>";
        assertTrue(xmlValidatorService.DetermineXml(validXml));
    }

    // Test case for an invalid XML scenario with missing closing tag
    @Test
    public void testInvalidXmlScenario4() {
        String invalidXml = "<root><element1>value1</element1><element2>value2</element2>";
        assertFalse(xmlValidatorService.DetermineXml(invalidXml));
    }

    // Test case for an empty XML string
    @Test
    public void testEmptyXml() {
        String emptyXml = "";
        assertFalse(xmlValidatorService.DetermineXml(emptyXml));
    }

    // Test case for a null XML string
    @Test
    public void testNullXml() {
        String nullXml = null;
        assertFalse(xmlValidatorService.DetermineXml(nullXml));
    }

    // Test case for mismatched opening and closing tags
    @Test
    public void testMismatchedTags() {
        String mismatchedTagsXml = "<root><element1>value1</element2></root>";
        assertFalse(xmlValidatorService.DetermineXml(mismatchedTagsXml));
    }

    // Test case for valid XML with nested tags
    @Test
    public void testNestedTags() {
        String nestedTagsXml = "<root><element1>value1<subelement>subvalue</subelement></element1></root>";
        assertTrue(xmlValidatorService.DetermineXml(nestedTagsXml));
    }

}
