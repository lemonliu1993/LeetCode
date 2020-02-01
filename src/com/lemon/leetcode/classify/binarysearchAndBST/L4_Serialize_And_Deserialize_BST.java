package com.lemon.leetcode.classify.binarysearchAndBST;

/**
 * leetcode449
 * <p>
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 * <p>
 * Created by lemoon on 20/2/1 下午4:07
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class L4_Serialize_And_Deserialize_BST {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            addToSB(sb, root);
            return sb.toString();
        }
    }

    private void addToSB(StringBuilder sb, TreeNode root) {
        if (root == null) {
            return;
        }
        sb.append(root.val + "#");
        addToSB(sb, root.left);
        addToSB(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] values = data.split("#");
        if (values == null || values.length == 0) {
            return null;
        }
        int[] valueNums = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            valueNums[i] = Integer.parseInt(values[i]);
        }
        TreeNode root = new TreeNode(valueNums[0]);
        generateTree(root, valueNums, 1, valueNums.length - 1);
        return root;
    }

    private void generateTree(TreeNode root, int[] valueNums, int left, int right) {
        if (root == null) {       //问题3 PS：这里要辅助
            return;
        }
        if (left > right) {     //问题1 PS:这里不能加＝
            return;
        }
        int index = left;
        while (index <= valueNums.length - 1 && valueNums[index] < root.val) { //问题5 PS：要注意数组越界问题
            index++;
        }
        if (index != left) {       //问题2 PS：这里要判断是否有左右子树
            root.left = new TreeNode(valueNums[left]);
        }
        if (index <= right) {       //问题4 PS：这里有没有右子树的判断要慎重
            root.right = new TreeNode(valueNums[index]);
        }
        generateTree(root.left, valueNums, left + 1, index - 1);
        generateTree(root.right, valueNums, index + 1, right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node = new TreeNode(1);
//        TreeNode node2 = new TreeNode(3);
        root.left = node;
//        root.right = node2;
        L4_Serialize_And_Deserialize_BST demo = new L4_Serialize_And_Deserialize_BST();
        String serialize = demo.serialize(root);
        System.out.println(serialize);
        TreeNode result = demo.deserialize(serialize);


    }
}
