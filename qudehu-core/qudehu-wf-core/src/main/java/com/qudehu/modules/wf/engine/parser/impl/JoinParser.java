package com.qudehu.modules.wf.engine.parser.impl;


import com.qudehu.modules.wf.engine.model.JoinModel;
import com.qudehu.modules.wf.engine.model.NodeModel;
import com.qudehu.modules.wf.engine.model.logicflow.LfNode;
import com.qudehu.modules.wf.engine.parser.AbstractNodeParser;

/**
 *
 * 合并节点解析器
 * @author qudehu
 * @date 2023/4/26
 */
public class JoinParser extends AbstractNodeParser {

    @Override
    public void parseNode(LfNode lfNode) {

    }

    @Override
    public NodeModel newModel() {
        return new JoinModel();
    }
}
