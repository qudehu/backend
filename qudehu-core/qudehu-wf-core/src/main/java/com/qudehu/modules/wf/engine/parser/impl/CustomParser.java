package com.qudehu.modules.wf.engine.parser.impl;

import cn.hutool.core.lang.Dict;
import com.qudehu.modules.wf.engine.model.CustomModel;
import com.qudehu.modules.wf.engine.model.NodeModel;
import com.qudehu.modules.wf.engine.model.logicflow.LfNode;
import com.qudehu.modules.wf.engine.parser.AbstractNodeParser;
import com.qudehu.modules.wf.enums.FlowConst;

/**
 * 自定义节点解析类
 * @author qudehu
 * @date 2023/12/7
 */
public class CustomParser extends AbstractNodeParser {
    @Override
    public void parseNode(LfNode lfNode) {
        CustomModel customModel = (CustomModel) nodeModel;
        Dict properties = lfNode.getProperties();
        customModel.setClazz(properties.getStr(CLASS_KEY));
        customModel.setMethodName(properties.getStr(METHOD_NAME_KEY));
        customModel.setArgs(properties.getStr(ARGS_KEY));
        customModel.setVar(properties.get(RETURN_VAL_KEY, FlowConst.CUSTOM_RETURN_VAL));
    }

    @Override
    public NodeModel newModel() {
        return new CustomModel();
    }
}
