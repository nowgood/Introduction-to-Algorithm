import random


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.color = 1  # 1 表示黑色, 0 表示红色
        self.left = None
        self.right = None
        self.parent = None


class RedBlackTree(object):
    def __init__(self, x):
        self.root = TreeNode(x)

    def insert(self, x):
        pass

    def _insert(self, x, root):
        pass

    def traverse_inorder(self):
        self._traverse_iter_inorder(self.root)
        print()

    @staticmethod
    def _traverse_iter_inorder(node):
        s = []
        while s or node:
            if node:
                s.append(node)
                node = node.left
            else:
                node = s.pop()
                print(node.val, end=" ")
                node = node.right


if __name__ == "__main__":
    rbt = RedBlackTree(10)
    random.seed(47)
    for i in range(10):
        rbt.insert(random.randint(1, 20))
    rbt.traverse_inorder()