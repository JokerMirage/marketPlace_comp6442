/**
 * @(#)Node.java, 5月 20, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.market.sever.config;


public class Node<T> {
    public long userId;
    public Thread thread;
    public Node leftChild;
    public Node rightChild;

    public Node(long id, Thread thread) {
        this.userId = id;
        this.thread = thread;
    }
}