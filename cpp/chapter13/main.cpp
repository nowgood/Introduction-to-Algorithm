//
// Created by wangbin on 2018/5/19.
//
#include <iostream>
#include "RedBlackTree.h"
#include <random>

using namespace std;
int main() {

    RedBlackTree rbt;
    srand(47);
    for (int i = 0; i < 5; i++) {
        rbt.insert(i);
    }

    cout << "遍历 red black tree" << endl << endl;
    rbt.inorder_traversal();
}

