package com.qudehu.modules.wf.engine.parser.impl;

import com.qudehu.modules.wf.engine.model.EndModel;
import com.qudehu.modules.wf.engine.model.NodeModel;
import com.qudehu.modules.wf.engine.model.logicflow.LfNode;
import com.qudehu.modules.wf.engine.parser.AbstractNodeParser;

/**
 *
 * 结束节点解析类
 * @author qudehu
 * @date 2023/4/26
 */
public class EndParser extends AbstractNodeParser {

    @Override
    public void parseNode(LfNode lfNode) {

    }

    @Override
    public NodeModel newModel() {
        return new EndModel();
    }
}
