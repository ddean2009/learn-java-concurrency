package com.flydean;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @author wayne
 * @version TreeNode,  2020/3/6 10:58 上午
 */

public class TreeNode {

    int value;

    Set<TreeNode> children;

    TreeNode(int value, TreeNode... children) {
        this.value = value;
        this.children = Sets.newHashSet(children);
    }
}