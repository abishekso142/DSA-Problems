package leetcode;

//https://leetcode.com/problems/same-tree/
public class SameTree
{
    public boolean isSameTree(TreeNode p, TreeNode q)
    {
          if(p == null && q != null)
              return false;
          else if(p != null && q == null)
              return false;
          else if( p == null && q == null)
              return true;
          else {
              if(p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right)) {
                  return true;
              }
              return false;
          }         
    }
}
 
class TreeNode
{

    int      val;
    TreeNode left;
    TreeNode right;

    public TreeNode()
    {
        val = 0;
        left = right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right)
    {
        super();
        this.val  = val;
        this.left  = left;
        this.right = right;
    }

}
