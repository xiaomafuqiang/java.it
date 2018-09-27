
##### 实体类要点
> hibernate 根据oid区分类
```html
<id name="id" column="id">
    <generator class="native"/>
</id>
```

```java
// 不能是final class 否则 load == get 延迟优化丧失
public class Customer {
    // 类型必须 包装类 否则 可能默认值有歧义
    private String name;
    private Integer id;

    // 提供默认构造器 用于hibernate反射
    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    // 提供getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
```
