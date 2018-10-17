package com.jis.platform.fmj.model.entity;

import com.jis.platform.common.vo.TreeNode;
import lombok.Data;

/**
 * Created by Ace on 2017/6/12.
 */
@Data
public class ProductCategoryTree extends TreeNode {
    private String title;
    private String value;
    private String label;


    public ProductCategoryTree() {
    }
    public ProductCategoryTree(int id, String name, int parentId) {
        this.id = id;
        this.parentId = parentId;
        this.title = name;
        this.label = name;
    }
    public ProductCategoryTree(int id, String name, ProductCategoryTree parent) {
        this.id = id;
        this.parentId = parent.getId();
        this.title = name;
        this.label = name;
    }


}
