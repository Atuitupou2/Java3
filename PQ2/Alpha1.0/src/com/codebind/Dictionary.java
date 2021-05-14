package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Dictionary {
    private JPanel MainPanel;
    private JList lstParts;
    private JTextField txtDelete;
    private JTextField txtAdd;
    private JTextField txtSearch;
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnSearch;
    //Binary tree is global allowing Delete and search functions to be updated from the insert method
    BinaryTree tree = new BinaryTree();
    //The search node is the returned node containing the searched string
    TreeNode searchNode = new TreeNode("");
    //A list is used to change the array because of the simple .Add feature which
    //Can be used regardless of having to refrence the index
    List<String> list = new ArrayList<String>();
    DefaultListModel model = new DefaultListModel();
    int position = 0;



    public Dictionary()
    {
        //This function runs when the user fills the add textbox and presses the add button
        //The add button adds a name into the parts binary tree
        btnAdd.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Message displays if user forgets to enter data
                if(txtAdd.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,
                            "Please enter text to add to dictionary");
                }
                else
                {
                    list.add(txtAdd.getText());
                    String[] names = new String[list.size()];
                    names = list.toArray(names);
                    //The array is sorted for the create balanced binary tree function which treats the array
                    //like numbers in order, sorting the array allows each element to be added balancing the tree
                    Arrays.sort(names);
                    tree.CreateBalancedTree(names,1,names.length);
                    //This ensures that the binary tree is saved for the delete and search functions

                    tree.SetForSearch(tree.GetRoot());
                    list.clear();
                    inOrder(tree.returnSearchRoot());
                    //The root is reset for other arrays to be entered into the binary tree
                    tree.SetRoot(null);
                }

            }
        });
        //This function runs when the user fills the delete textbox and presses the delete button
        //The delete button deletes a name from the parts binary tree
        btnDelete.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(txtDelete.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,
                            "Please enter valid text to delete from the dictionary");
                }
                else
                {
                    boolean resume = true; int index = 0; boolean found = false;
                    //This loop continues until either the item to be deleted is found within the list box
                    //Or until all the elements within the list box (or binary tree) have been tested
                    while(resume && index < list.size())
                    {
                        String part = model.get(index).toString();
                        if(part.compareTo(txtDelete.getText()) == 0 )
                        {
                            //If the delete criteria is found then the delete button removes the item in the listbox
                            model.remove(index);
                            //The item is also removed from the list box to be (put into the binary tree later)
                           //Collections.sort(list,Collections.reverseOrder());
                            list.remove(index);
                            resume = false;
                            found = true;
                        }
                        index++;
                    }
                    //If the delete text doesn't match display an error message
                    if(found == false)
                    {
                        JOptionPane.showMessageDialog(null,
                                "Please enter valid part to delete");
                    }
                    //If the delete text is found within the listbox (binary tree)
                    else
                    {
                        String[] names = new String[list.size()];
                        //The array is sorted for the create balanced binary tree function which treats the array
                        //like numbers in order, sorting the array allows each element to be added balancing the tree
                        names = list.toArray(names);
                        Arrays.sort(names);
                        //This method has a return type however it is only needed within the function not outside
                        //This is why no variable stores the return value
                        tree.CreateBalancedTree(names,1,names.length);
                        //This ensures that the binary tree is saved for the delete and search functions
                        list.clear();
                        tree.SetForSearch(tree.GetRoot());
                        inOrder(tree.returnSearchRoot());
                        //The root is reset for other arrays to be entered into the binary tree
                        tree.SetRoot(null);
                    }
                }
            }
        });
        //This function runs when the user fills the search text box and presses the search button
        //This button searches for a name within the parts  binary tree and returns the result.
        btnSearch.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(txtSearch.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,
                            "Please enter valid search criteria");
                }
                else
                {
                    String search = txtSearch.getText();
                    //This returns a node which is either null (meaning not found) or returns a filled in node with the search name
                    searchNode = tree.Search(search);
                    if(searchNode == null)
                    {
                        JOptionPane.showMessageDialog(null,
                                search + " not found");
                    }
                    else
                    {
                        //if the Search text field is empty after entering the data display an error message
                        JOptionPane.showMessageDialog(null,
                                search + " FOUND");
                    }
                }
            }
        });


    }

    private void inOrder(TreeNode node)
    {
        //This function populates the list box
        if(node == null){return;}
        inOrder(node.leftNode);

        list.add(node.name);
        model.clear();

        position = list.size() - 1;
        for(int index = 0; index <= position; index++)
        {
            model.addElement(list.get(index));
        }
        lstParts.setModel(model);

        /*while(position >= 0)
        {
            model.addElement(list.get(position));
            position--;
        }
        lstParts.setModel(model);
        */

        //The List box is displayed in the same order as the balanced binary tree

        inOrder(node.rightNode);
    }
    public static void main(String[] args)
    {
        //This automaticaly creates the window and components when run
        JFrame Frame = new JFrame("Dictionary");
        Frame.setContentPane(new Dictionary().MainPanel );
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.pack();
        Frame.setVisible(true);
    }
}
