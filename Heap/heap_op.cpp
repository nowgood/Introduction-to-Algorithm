#include<iostream>
#include<vector>
#include <map>
using namespace std;

void maxHeapify(vector<int>& nums, int node){
    int largest = node;
    int left = (node+1)*2-1;
    int right = left + 1;
    if (left<nums.size() && nums[left] > nums[largest]) { // 这里是比最大的大
        largest = left;

    }
    if (right<nums.size() && nums[right] > nums[largest]) {
        largest = right;
    }

    if (largest != node) {
        swap(nums[largest], nums[node]);
        maxHeapify(nums, largest);
    }
}
void buildHeap(vector<int>& nums) {
    for (int i = nums.size()/2-1; i>=0; i--) { // ((nums.size()-1)+1)/2-1
        maxHeapify(nums, i);
    }
}

int heapPop(vector<int>& nums) {
    int ans = -1;
    if (nums.size() == 0) {
        cout << "null heap";
        return ans;
    }
    ans = nums[0];
    nums[0] = nums[nums.size()-1];
    nums.pop_back();
    maxHeapify(nums, 0);
    return ans;

}

void heapPush(vector<int>& nums, int val) {
    nums.push_back(val);
    int adj = int(nums.size()) - 1;
    while(adj > 0) {
        int father = adj+1/2-1;
        if (nums[father] < nums[adj]) {
            swap(nums[father], nums[adj]);
            adj = father;
        } else {
            break;
        }
    }
}

int main() {

    vector<int> v = {4, 5 ,7, 10};
    buildHeap(v);
    for (auto e : v) {
        cout << e << endl;
    }
    int size = int(v.size());
    for (int i = 0; i < size; i++) {
        cout << heapPop(v) << endl;
    }
    heapPush(v, 1);
    heapPush(v, 5);
    heapPush(v, 7);
    size = int(v.size());
    cout << endl;
    for (int i = 0; i < size; i++) {
        cout << heapPop(v) << endl;
    }

}
