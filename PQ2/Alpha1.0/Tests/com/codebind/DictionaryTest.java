package com.codebind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {

    @Test
    void main()
    {

        BinaryTree tree = new BinaryTree();
        String[] testArray = new String[10];
        testArray[0] = "bumperA";    testArray[1] = "wheelB";  testArray[2] = "bumperB";
        testArray[3] = "windshieldA";testArray[4] = "panelA";  testArray[5] = "windshieldB";
        testArray[6] = "panelB";     testArray[7] = "springA"; testArray[8] = "wheelA";
        testArray[9] = "springB";
        Arrays.sort(testArray);
        TreeNode node = tree.CreateBalancedTree(testArray,1, testArray.length);
        tree.SetForSearch(node);

        for(int index = 0; index < testArray.length;index++)
        {
            TreeNode searchNode = tree.Search(testArray[index]);
            Assertions.assertEquals(searchNode.name,testArray[index]);
        }

        testArray[0] = "wiperA";        testArray[1] = "exhaustA";  testArray[2] = "wheelRimB";
        testArray[3] = "wiperB";        testArray[4] = "exhaustB";  testArray[5] = "radiatorB";
        testArray[6] = "sparkplugA";    testArray[7] = "wheelRimA"; testArray[8] = "radiatorA";
        testArray[9] = "sparkplugB";

        Arrays.sort(testArray);
        TreeNode node2 = tree.CreateBalancedTree(testArray,1, testArray.length);
        tree.SetForSearch(node2);

        for(int index = 0; index < testArray.length;index++)
        {
            TreeNode searchNode = tree.Search(testArray[index]);
            Assertions.assertEquals(searchNode.name,testArray[index]);
        }

    }
}