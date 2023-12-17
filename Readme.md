# Read-me doc : Xml Validator Service

The `XmlValidatorService` is a Java class that provides methods for validating XML strings. It utilizes a stack-based
approach to track opening and closing tags, ensuring that the XML structure is well-formed. The implementation can be found here -
src/main/java/com/jain/mayank/service/XmlValidatorService.java

## Methods

### `public boolean DetermineXml(String xmlString)`

Determines if the given XML string is valid.

#### Method Details

1. Checks for basic XML structure, ensuring the string is not null or empty and starts with '<' and ends with '>'.
2. Iterates through each character in the XML string, identifying opening and closing tags.
3. Calls `extractStringFromTags` method to extract tags and updates the stack accordingly.
4. Calls `validateXML` method to validate the XML structure.
5. Returns `true` if the stack is empty (all opening tags have corresponding closing tags), otherwise `false`.

- **Tests:**
    - I have used JUnit 4 library to test various valid and invalid scenarios. The same can be checked in
      src/test/java/com/jain/mayank/service/XmlValidatorServiceTest.java

- **Instructions to run code:**
    - Java version: 20 or above
    - Build system: Maven
    - Preferred IDE: Intellij IDEA

## Additional Notes

Assumptions: It is considered that <></> is a valid xml string.

