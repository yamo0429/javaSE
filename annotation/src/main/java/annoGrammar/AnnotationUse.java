package annoGrammar;

@AnnotationDefinition(desc = "类描述", author = "jack类") // TODO 如果注解里没有默认值，则这里会报错
public class AnnotationUse {

    @AnnotationDefinition(desc = "属性描述", author = "jack属性")
    public int xxx;

    @AnnotationDefinition(desc = "方法描述", author = "jack方法")
    void speak() {
        System.out.println("哈哈，我被调用了");
    }
    @AnnotationDefinition(desc = "方法描述", author = "jack方法")
    void say(String sentence) {
        System.out.println("哈哈，我被调用了：" + sentence);
    }

}
