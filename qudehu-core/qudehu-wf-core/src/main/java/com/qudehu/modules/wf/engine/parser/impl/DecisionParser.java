package com.qudehu.modules.wf.engine.parser.impl;


import cn.hutool.core.lang.Dict;
import com.qudehu.modules.wf.engine.parser.AbstractNodeParser;
import com.qudehu.modules.wf.engine.model.DecisionModel;
import com.qudehu.modules.wf.engine.model.NodeModel;
import com.qudehu.modules.wf.engine.model.logicflow.LfNode;

/**
 *
 * 决策节点解析类
 * @author qudehu
 * @date 2023/4/26
 */
public class DecisionParser extends AbstractNodeParser {
    /**
     * 解析decision节点特有属性
     * @param lfNode
     */
    @Override
    public void parseNode(LfNode lfNode) {
        DecisionModel decisionModel = (DecisionModel) nodeModel;
        Dict properties = lfNode.getProperties();
        decisionModel.setExpr(properties.getStr(EXPR_KEY));
        decisionModel.setHandleClass(properties.getStr(HANDLE_CLASS_KEY));
    }

    @Override
    public NodeModel newModel() {
        return new DecisionModel();
    }
}
