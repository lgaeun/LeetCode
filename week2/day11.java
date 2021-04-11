/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int deepest = -1, sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    static void dfs(TreeNode root,int depth){
        if(root == null) return; //null이면 그냥 return 
        if(root.left==null && root.right==null){ //leaf
            if(depth == deepest) sum += root.val; //maxdepth와 같은 leaf일때 sum 누적 계산
            if(depth > deepest) { //더 깊은노드가 나타나면 거기부터 다시 sum 계산 시작
                sum = root.val;
                deepest = depth;
            }
        }
        dfs(root.left, depth+1);    //왼,오자식 탐색(첫줄에서 null일때 바로 리턴하므로 if문으로 null인지 확인필요 없음)
        dfs(root.right, depth+1);
    }
   
}

//통과못하는 테케가 있음 [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5] 롸..?
//여튼 time: O(n) 트리의 개수만큼, space:O(n)
