package leetcode;

//https://leetcode.com/problems/invert-binary-tree/
public class InvertTree
{

    public TreeNode invertTree(TreeNode root)
    {
        TreeNode ref = root;
        if(root != null && ( root.left != null || root.right!=null)) {
            invertTree(root.left);
            invertTree(root.right);
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            
        }
        return ref;
    } 
}
