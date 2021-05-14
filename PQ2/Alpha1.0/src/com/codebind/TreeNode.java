package com.codebind;

public class TreeNode
{
    //There can be many nodes within a balanced binary tree
    //Each node stores a parts name within the tree.
    public String name;
    //Each node has a branch node which can be null if the node is a leaf node (no branching node)
    public TreeNode rightNode;
    public TreeNode leftNode;
    //Function sets the right node used within the create balanced tree function
    public void SetRightNode(TreeNode node){this.rightNode = node;}
    //Function sets the left node used within the create balanced tree function
    public void SetLeftNode(TreeNode node){this.leftNode = node;}
    //Used for the root node which needs a default value (first string in listbox)
    public TreeNode(String name){this.name = name;}
    //Function is used to search each node within the binary tree for a specfic name
    public TreeNode search(String name)
    {
        //Sets the current node to the root node or the next node recursivly
        TreeNode currentNode =  this;
        //While the changing node is not a node with a null value which means
        //That the parts list within the binary tree has not ended
        while(currentNode != null)
        {
            //Checks if the changing node has the parts name
            if (name.compareTo(currentNode.name) == 0)
            {
                return currentNode;
            }
            //Alphabeticaly moves down the binary tree either choosing the left or right
            //This is a very quick way of finding the searched text entered by the user
            if((name.compareTo(currentNode.name) < 0))
            {
                currentNode = currentNode.leftNode;
            }
            else
            {
                currentNode = currentNode.rightNode;
            }
        }
        //If the search criteria is not found then return null which diaplays a not found message
        return null;
    }
}
