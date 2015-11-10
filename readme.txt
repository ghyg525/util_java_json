JSON是JavaScript Object Notation的缩写，是一种轻量级的数据交换形式，
JSON是一种XML的替代方案，而且比XML更小，更快而且更易于解析。
因为JSON描述对象的时候使用的是JavaScript语法，它是语言和平台独立的，



<1> Gson (Google)

Gson能实现Java对象和JSON之间的相互转换。
1）提供简单的toJson()方法和fromJson()去实现相互转换。
2）可以从JSON中转换出之前存在的不可改变的对象。
3）扩展提供了Java泛型。
4）支持任意复杂的对象。


<2> Jackson (Spring集成)

Jackson库是一个“旨在为开发者提供更快，更正确，更轻量级，更符合人性思维” 的类库。
Jackson提供了三种可选的JSON处理方法：

1 流模式：（也称为"增量分析/生成"） 读取和写入 JSON 内容作为离散事件。
org.codehaus.jackson.JsonParser 读， org.codehaus.jackson.JsonGenerator 写。

2 树模型 ：提供一个 JSON 文档可变内存树的表示形式。
org.codehaus.jackson.map.ObjectMapper 生成树 ；树组成 JsonNode 节点集。
树模型类似于 XML DOM。

3 数据绑定： JSON和POJO相互转换，基于属性访问器规约或注解。
有 两种变体： 简单 和 完整 的数据绑定：
简单数据绑定： 是指从Java Map、List、String、Numbers、Boolean和空值进行转换
完整数据绑定 ：是指从任何 Java bean 类型 （及上文所述的"简单"类型） 进行转换
org.codehaus.jackson.map.ObjectMapper 对两个变种，进行编组（marshalling ）处理 （写入 JSON） 和反编组（unmarshalling ，读 JSON）。
JAXB激励下的基于注释的 （代码优先）变种。

从使用的角度来看，总结这些3 种方法的用法如下：
流模式： 性能最佳的方式 （最低开销、 速度最快的读/写； 其它二者基于它实现）。
树模式： 最灵活的方式。
数据绑定 ：使用最方便的方式。


<3> json lib

JSON-lib类库是基于Douglas Crockford的工作成果，能转换bean，map，集合（collection），
java数组和XML转换成JSON并能反向转换成beans和动态bean（DynaBean）。


<4> json org

