You are given pointer to the root of the binary search tree and two values  and . You need to return the lowest common ancestor (LCA) of  and  in the binary search tree.

In the above example, the lowest common ancestor of the nodes  and  is the node , as  is the lowest common node which has both the nodes  and  as it's descendants.

You only need to complete the function.

Input Format

You are given a function,

node * lca (node * root ,int v1,int v2) {

}
It is guaranteed that v1 and v2 are present in the tree.

Node is defined as :

struct node
{
int data;
node * left;
node * right;
}node;
Output Format

Return the LCA of  and .

Sample Input

         4
       /   \
      2     7
     / \   /
    1   3 6
 and .

Sample Output

LCA of  and  is  (which is the root). 
Return a pointer to the root in this case.
