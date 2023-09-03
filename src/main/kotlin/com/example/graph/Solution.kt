package com.example.graph

class Solution {
    private val map = HashMap<Node, Node>()
    fun cloneGraph(node: Node?): Node? {
        if (node == null) {
            return node
        }
        if (map.containsKey(node)) {
            return map[node]
        }
        val cloneNode = Node(node.`val`)
        map[node] = cloneNode
        for (childNode in node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(childNode))
        }
        return cloneNode
    }
}
