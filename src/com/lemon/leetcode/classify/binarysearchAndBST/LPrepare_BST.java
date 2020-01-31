package com.lemon.leetcode.classify.binarysearchAndBST;

/**
 * Created by lemoon on 20/1/30 下午10:54
 */
public class LPrepare_BST {


    void insert(TreeNode root, TreeNode node) {
        if (root == null) {
            root = node;
            return;
        } else {
            insertRecursive(root, node);
        }
    }

    private void insertRecursive(TreeNode root, TreeNode node) {
        if (root.val > node.val) {
            if (root.left == null) {
                root.left = node;
            } else {
                insertRecursive(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                insertRecursive(root.right, node);
            }
        }
    }

    boolean bst_search(TreeNode node,int val){
        if(node.val == val){
            return true;
        }
        if(node.val>val){
            if(node.left==null){
                return false;
            }else{
                return bst_search(node.left,val);
            }
        }else{
            if(node.right==null){
                return false;
            }else{
                return bst_search(node.right,val);
            }
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    void preOrder_print(TreeNode node,int level){
        if(node==null){
            return;
        }
        for(int i =0;i<level;i++){
            System.out.print("---");
        }
        System.out.println(node.val);
        preOrder_print(node.left,level+1);
        preOrder_print(node.right,level+1);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(10);
        TreeNode node5 = new TreeNode(15);
//        TreeNode node6 = new TreeNode(8);
        LPrepare_BST lPrepare_bst = new LPrepare_BST();
        lPrepare_bst.insert(node,node1);
        lPrepare_bst.insert(node,node2);
        lPrepare_bst.insert(node,node3);
        lPrepare_bst.insert(node,node4);
        lPrepare_bst.insert(node,node5);
        lPrepare_bst.preOrder_print(node,0);

        System.out.println(lPrepare_bst.bst_search(node, 2));

    }
}
