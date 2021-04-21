/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root==null) return ans;
        ans.add(root.val);
        for(Node child : root.children){
            preorder(child);
        }
        return ans;
    }
}
//List앞에 stataic을 붙이면 메모리에 고정돼서 테케 돌릴때마다 같은 list에 쌓임!! 제일 빠른 방법

class Solution {
    public LinkedList<Integer> preorder(Node root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if(root==null) return ans;
        if(!root.children.isEmpty()){
            for(Node child : root.children){
                ans.addAll(preorder(child));
            }
        }
        ans.addFirst(root.val);
        return ans;
    }
}
// child에서 preorder로 올라온 linkedlist의 앞에 자신의값(root.val)를 붙이고 다시 리턴하는 방식
// 매번 list를 생성하고, 리스트에 addAll할때마다 head, tail 다시설정해줘야하므로 위의 방법보단 오래걸림

