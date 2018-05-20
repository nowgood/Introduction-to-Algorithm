//
// Created by wangbin on 2018/5/19.
//

#ifndef INTRODUCTION2ALGS_REDBLACKTREE_H
#define INTRODUCTION2ALGS_REDBLACKTREE_H

#include <iostream>
#include <stack>
using namespace std;

enum color {red, black};
struct TreeNode {
    int val;
    color clr;
    TreeNode* left;
    TreeNode* right;
    TreeNode* parent;

    TreeNode(int val, color clr, TreeNode* left, TreeNode* right, TreeNode* parent):
            val{val}, clr{clr}, left{left}, right{right}, parent{parent}{}
    TreeNode(int val, color clr): val{val}, clr{clr}, left{nullptr}, right{nullptr}, parent{nullptr}{}

    TreeNode(TreeNode& treeNode) {
        cout << "copy construct function" << endl;
        val = treeNode.val;
        clr = treeNode.clr;
        left = treeNode.left;
        right = treeNode.right;
        parent = treeNode.parent;
    }
};

class RedBlackTree {
public:
    RedBlackTree(){
        root = nullptr;
    }
    void insert(int x);
    void inorder_traversal();
    void inorder(TreeNode* &p) const;

private:
    TreeNode* root;
    TreeNode* nil =  new TreeNode(-1, black, nullptr, nullptr, nullptr);
    void inorder_traversal(TreeNode* p) const;
    void bst_insert(const int x, TreeNode* &p);
    void insert(const int x, TreeNode* p);
    void balance_rbtree(TreeNode* &p);
    void left_rotate_1(TreeNode* &p);
    void left_rotate_2(TreeNode* &p, TreeNode* &root);
    void right_rotate_1(TreeNode* &p);
    void right_rotate_2(TreeNode* &p, TreeNode* &root);
};

#endif //INTRODUCTION2ALGS_REDBLACKTREE_H
