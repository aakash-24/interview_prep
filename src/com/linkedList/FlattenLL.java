package com.linkedList;
//https://www.geeksforgeeks.org/flattening-a-linked-list/

/*Input : 5 -> 10 -> 19 -> 28
        |    |     |     |
        V    V     V     V
        7    20    22    35
        |          |     |
        V          V     V
        8          50    40
        |                |
        V                V
        30               45    */

/*
Output : 5-> 7-> 8- > 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50
*/

public class FlattenLL {

    // An utility function to merge two sorted linked lists
   static class Node
    {
        int data;
        Node right, down;
        Node(int data)
        {
            this.data = data;
            right = null;
            down = null;
        }
    }

    Node merge(Node a, Node b)
    {
        if (a == null)     return b;
        if (b == null)      return a;
        Node result;
        if (a.data < b.data)
        {
            result = a;
            result.down =  merge(a.down, b);
        }
        else
        {
            result = b;
            result.down = merge(a, b.down);
        }
        result.right = null;
        return result;
    }

    Node flatten(Node root)
    {
        // Base Cases
        if (root == null || root.right == null)
            return root;
        // recur for list on right
        root.right = flatten(root.right);

        // now merge
        root = merge(root, root.right);

        // return the root
        // it will be in turn merged with its left
        return root;
    }

}
