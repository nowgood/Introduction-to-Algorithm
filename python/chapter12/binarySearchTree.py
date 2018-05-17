import random


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class SearchTree(object):
    def __init__(self, x):
        self.root = TreeNode(x)

    def insert(self, x):
        self._insert(x, self.root)

    def insert_iter(self, x):
        self._insert_iter(x, self.root)

    def find(self, x):
        return self._find(x, self.root)

    def find_iter(self, x):
        return self._find_iter(x, self.root)

    def traverse_preorder(self):
        self._traverse_iter_preorder(self.root)
        print()

    def traverse_inorder(self):
        self._traverse_iter_inorder(self.root)
        print()

    def traverse_postorder(self):
        self._traverse_iter_postorder(self.root)
        print()

    def find_max(self):
        node = self.root
        while node.right:
            node = node.right
        return node.val

    def find_min(self):
        node = self.root
        while node.left:
            node = node.left
        return node.val

    def _insert(self, x, node):
        if x < node.val:
            if node.left:
                self._insert(x, node.left)
            else:
                node.left = TreeNode(x)
        else:
            if node.right:
                self._insert(x, node.right)
            else:
                node.right = TreeNode(x)

    def _insert_iter(self, x, node):
        flag = True
        while flag:
            if x < node.val:
                if node.left:
                    node = node.left
                else:
                    node.left = TreeNode(x)
                    flag = False
            else:
                if node.right:
                    node = node.right
                else:
                    node.right = TreeNode(x)
                    flag = False

    def _find(self, x, node):
        if x < node.val:
            if node.left:
                return self._find(x, node.left)
            else:
                print("Do not find %d" % x,  end="\t")
        elif x > node.val:
            if node.right:
                return self._find(x, node.right)
            else:
                print("Do not find %d" % x, end="\t")
        else:
            return node.val

    @staticmethod
    def _find_iter(x, node):

        while True:
            if x < node.val:
                if node.left:
                    node = node.left
                else:
                    print("Do not find %d" % x,  end="\t")
                    return
            elif x > node.val:
                if node.right:
                    node = node.right
                else:
                    print("Do not find %d" % x, end="\t")
                    return
            else:
                return node.val

    @staticmethod
    def _find_parent(x, node):
        parent = None
        while True:
            if x < node.val:
                if node.left:
                    parent = node
                    node = node.left
                else:
                    print("Do not find %d" % x)
                    return
            elif x > node.val:
                if node.right:
                    parent = node
                    node = node.right
                else:
                    print("Do not find %d" % x)
                    return
            else:
                return parent, node

    def _traverse(self, node):
        if node:
            print(node.val, end=" ")
            self._traverse(node.left)
            self._traverse(node.right)

    @staticmethod
    def _traverse_iter_preorder(node):
        s = []
        while s or node:
            if node:
                print(node.val, end=" ")
                s.append(node)
                node = node.left
            else:
                node = s.pop().right

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

    ''' 以下面的树结构来理清后序遍历的思路
          o
         /
        o 
       / \
      o   o
    '''
    @staticmethod
    def _traverse_iter_postorder(node):

        s = []
        while s or node:
            if node:
                s.append(node)
                node = node.left
            else:
                node = s[-1].right
                if node is None:
                    node = s.pop()
                    print(node.val, end=" ")
                    while s and node is s[-1].right:
                        node = s.pop()
                        print(node.val, end=" ")
                if s is not None:
                    '''
                    s = []
                    s is not None: True
                    if s: s 虽然不是None, 但是 if 语句在判断是, 如果是空列表则判断为假
                    '''
                    node = s[-1].right
                else:
                    # 后序遍历, 如果栈为空表明所有节点都已经处理了
                    break  # or node = None, very important!

    def delete(self, x):

        if x == self.root.val:  # 1. 删除节点为根节点, 特殊点就是没有父节点, 所以不用更新父节点
            node = self.root
            if node.right and node.left:  # 2. 删除节点有左右孩子
                self._transpose(node)
            elif node.right:  # 3.1 删除节点有右孩子
                self.root.right = node.right
            elif node.left:  # 3.2 删除节点有左孩子
                self.root.left = node.left
            else:
                self.root = None  # 4. 删除节点为叶节点
        else:
            parent, node = self._find_parent(x, self.root)
            print("parent: ", parent.val, "node: ", node.val)

            if node is None:
                print("%d not exists" % x)
                return

            if node.right and node.left:
                self._transpose(node)
                return  # solely
            elif node.right:
                update = node.right
            elif node.left:
                update = node.left
            else:
                update = None

            # 判断当前节点是父节点的左孩子还是右孩子
            if parent.left is node:
                parent.left = update
            else:
                parent.right = update

    """
    处理删除节点有两个儿子节点的情况, node 为删除节点
    """
    @staticmethod
    def _transpose(node):
        parent = node
        node = node.right
        if node.left is None:  # 后继为删除节点的右孩子
            parent.right = node.right
        elif node.left is not None:
            while node.left.left:
                node = node.left
            parent.val = node.left.val
            node.left = node.left.right
            """以上代码处理如下情况
                 o 
                /
               o
                \
                 o
            """


if __name__ == "__main__":

    tree = SearchTree(10)
    random.seed(10)
    for i in range(8):
        tree.insert_iter(random.randint(1, 20))

    tree.traverse_preorder()
    tree.traverse_inorder()
    tree.traverse_postorder()
    print(tree.find(19))
    print(tree.find_iter(19))
    print(tree.find(18))
    print(tree.find_iter(18))
    print(tree.find_min())
    print(tree.find_max())
    # tree.delete(10)
    # tree.delete(19)
    # tree.delete(14)
    # tree.delete(15)
    tree.traverse_preorder()
    tree.traverse_inorder()
    tree.traverse_postorder()