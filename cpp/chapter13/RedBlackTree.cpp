//
// Created by wangbin on 2018/5/19.

#include <iostream>
#include "RedBlackTree.h"
using namespace std;

void RedBlackTree::inorder(TreeNode* &p) const{
    if (p == nullptr) {
        return;
    }
    inorder(p->left);
    cout << p->val << endl;
    inorder(p->right);
}

void RedBlackTree::inorder_traversal() {
    inorder_traversal(root);
}

void RedBlackTree::insert(int x) {
    if (root == nullptr) {
        root = new TreeNode{x, black, nil, nil, nullptr};
    } else{
        insert(x, root);
    }
}

void RedBlackTree::insert(const int x, TreeNode* p) {
    TreeNode* parent = nullptr;
    while (p != nil) {
        parent = p;
        if (x < p->val) {
            p = p->left;
        } else {
            p = p->right;
        }
    }
    p = new TreeNode(x, red, nil, nil, parent);
    if (x < parent->val) {
        parent->left = p;
    } else {
        parent->right = p;
    }
    balance_rbtree(p);
}

void RedBlackTree::balance_rbtree(TreeNode* &p) {

    while (p != root) {
        if (p->parent->clr == black) {  // case1
            return;
        }
        if (p->parent->clr == red) {
            if (p->parent == p->parent->parent->left &&  // case2
                p->parent->parent->right->clr == red) {
                if (p->parent->parent == root) {  // 如果从下处理到根节点, 则树的黑高增加1
                    p->parent->clr = black;
                    p->parent->parent->clr = black;
                    p->parent->parent->right->clr = black;
                    p = root;
                } else {
                    p->parent->clr = black;
                    p->parent->parent->clr = red;
                    p->parent->parent->right->clr = black;
                    p = p->parent->parent;
                }

            } else if (p->parent->parent->right == p->parent &&  // case2
                       p->parent->parent->left->clr == red) {
                if (p->parent->parent == root) {
                    p->parent->clr = black;
                    p->parent->parent->clr = black;
                    p->parent->parent->left->clr = black;
                    p = root;
                } else {
                    p->parent->clr = black;
                    p->parent->parent->clr = red;
                    p->parent->parent->left->clr = black;
                    p = p->parent->parent;
                }
                /*叔叔节点是黑色, 如果祖父节点不是根节点, 则还要更新祖父的父亲节点
                 * 叔叔节点是黑色, 有两种情况, 如果自己, 父亲, 祖父节点在一条线上, 只需要依次旋转
                 * 如果3者是"之"字型则是需要两次旋转
                 * */
            } else if (p->parent->parent->left == p->parent &&  // case3
                       p->parent->parent->right->clr == black) {
                if (p == p->parent->left) {
                    left_rotate_2(p, root);
                } else {
                    left_rotate_1(p);
                }
            } else if (p->parent->parent->right == p->parent &&  // case3
                       p->parent->parent->left->clr == black) {
                if (p == p->parent->right) {
                    right_rotate_2(p, root);
                } else {
                    right_rotate_1(p);
                }
            }
        }
    }
}

void RedBlackTree::left_rotate_1(TreeNode* &p) {
    TreeNode* tp;
    tp = p->parent->parent;
    p->parent->parent->left = p;
    p->parent->parent = p;
    p->left = p->parent;
    p->left->right = nil;
    p->parent = tp;
    p = p->left;
}

void RedBlackTree::left_rotate_2(TreeNode* &p,  TreeNode*& root) {
    TreeNode* tp;

    p->parent->clr = black;
    p->parent->parent->clr = red;
    tp = p->parent->parent->parent;

    p->parent->parent->left = p->parent->right;
    p->parent->right->parent = p->parent->parent;

    p->parent->right = p->parent->parent;
    p->parent->parent->parent = p->parent;
    p->parent->parent = tp;
    if (p->parent->right != root) {
        if (p->parent->parent->left == p->parent->right) {
            p->parent->parent->left = p->parent;
        } else {
            p->parent->parent->right = p->parent;
        }
    } else {
        root = p->parent;
    }
    p = p->parent;
}

void RedBlackTree::right_rotate_1(TreeNode* &p) {
    TreeNode* tp;
    tp = p->parent->parent;
    p->parent->parent->right = p;
    p->parent->parent = p;
    p->right = p->parent;
    p->right->left = nil;
    p->parent = tp;
    p = p->right;
}

void RedBlackTree::right_rotate_2(TreeNode* &p, TreeNode*& root) {
    TreeNode* tp;

    p->parent->clr = black;
    p->parent->parent->clr = red;
    tp = p->parent->parent->parent;

    p->parent->parent->right = p->parent->left;
    p->parent->left->parent = p->parent->parent;

    p->parent->left = p->parent->parent;
    p->parent->parent->parent = p->parent;
    p->parent->parent = tp;
    if (p->parent->left != root) {
        if (p->parent->parent->left == p->parent->left) {
            p->parent->parent->left = p->parent;
        } else {
            p->parent->parent->right = p->parent;
        }
    } else {
        root = p->parent;
    }
    p = p->parent;
}

void RedBlackTree::inorder_traversal(TreeNode* p) const {
    if (p == nullptr) {
        cout << "tree is null" << endl;
    }
    stack<TreeNode*> s{};
    while (!s.empty() || p != nil) {

        if (p != nil) {
            // printf("%d\n", s.size());
            s.push(p);
            p = p->left;
        } else {
            p = s.top();
            s.pop();
            cout << p->val << " " << p->clr << endl;
            p = p->right;
        }
    }
}

void  RedBlackTree::bst_insert(const int x, TreeNode* &p) {
    /*很重要的一点就是参数的传递是传引用, 这样在后面处理的结果直接反应在 p 上,
     * 而不用像 java, python 通过函数的返回值来获取改变结果, 然后复制给 p
     * */
    if (p == nullptr) {
        p = new TreeNode(x, red);
    } else if (x < p->val) {
        bst_insert(x, p->left);
    } else {
        bst_insert(x, p->right);
    }
}
