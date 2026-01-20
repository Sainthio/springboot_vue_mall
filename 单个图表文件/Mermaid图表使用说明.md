# Mermaid图表使用说明

## 如何复制到 mermaid.live 官网查看

### ⚠️ 重要提示
复制时**只复制代码块内的内容**，**不要包含** ```mermaid 和 ``` 这两个标记！

---

## 示例：正确的复制方法

### ❌ 错误方式（不要这样复制）：
```
```mermaid
classDiagram
    class A
```
```

### ✅ 正确方式（只复制这部分）：
```
classDiagram
    class A
```

---

## 快速测试图表

### 测试1：简单的类图
复制以下内容到 https://mermaid.live/ ：

```
classDiagram
    class User {
        +String name
        +String email
    }
    class Order {
        +Long id
        +Float total
    }
    User ||--o{ Order : creates
```

### 测试2：简单的时序图
复制以下内容到 https://mermaid.live/ ：

```
sequenceDiagram
    participant U as 用户
    participant S as 系统
    U->>S: 登录请求
    S-->>U: 返回Token
```

---

## 完整图表代码（可直接复制）

### 1. 核心实体类图

```
classDiagram
    class YonghuEntity {
        +Long id
        +String zhanghao
        +String mima
        +String nicheng
        +String xingbie
        +String shouji
        +String youxiang
        +Float money
        +Date addtime
    }
    
    class ShangpinxinxiEntity {
        +Long id
        +String shangpinbianhao
        +String shangpinmingcheng
        +String shangpinleixing
        +String pinpai
        +String guige
        +String tupian
        +String shangpinjieshao
        +Integer thumbsupnum
        +Integer crazilynum
        +Date clicktime
        +Date reversetime
        +Integer clicknum
        +Float price
        +Integer onelimittimes
        +Integer alllimittimes
    }
    
    class ShangpinleixingEntity {
        +Long id
        +String shangpinleixing
        +Date addtime
    }
    
    class OrdersEntity {
        +Long id
        +String orderid
        +String tablename
        +Long userid
        +Long goodid
        +String goodname
        +String picture
        +Integer buynumber
        +Float price
        +Float discountprice
        +Float total
        +Float discounttotal
        +Integer type
        +String status
        +String address
        +String tel
        +String consignee
        +String logistics
        +Date addtime
    }
    
    class CartEntity {
        +Long id
        +String tablename
        +Long userid
        +Long goodid
        +String goodname
        +String picture
        +Integer buynumber
        +Float price
        +Float discountprice
        +Date addtime
    }
    
    class AddressEntity {
        +Long id
        +Long userid
        +String address
        +String name
        +String phone
        +String isdefault
        +Date addtime
    }
    
    class StoreupEntity {
        +Long id
        +Long userid
        +Long refid
        +String tablename
        +String name
        +String picture
        +String type
        +String inteltype
        +Date addtime
    }
    
    class DiscussshangpinxinxiEntity {
        +Long id
        +Long refid
        +Long userid
        +String nickname
        +String content
        +String reply
        +Date addtime
    }
    
    class ChatEntity {
        +Long id
        +Long userid
        +Long adminid
        +String ask
        +String reply
        +Integer isreply
        +Date addtime
    }
    
    class NewsEntity {
        +Long id
        +String title
        +String introduction
        +String picture
        +String content
        +Date addtime
    }
    
    class UserEntity {
        +Long id
        +String username
        +String password
        +String role
        +Date addtime
    }
    
    class TokenEntity {
        +Long id
        +Long userid
        +String username
        +String tablename
        +String role
        +String token
        +Date addtime
        +Date expiratedtime
    }
    
    YonghuEntity ||--o{ OrdersEntity : "1对多"
    YonghuEntity ||--o{ CartEntity : "1对多"
    YonghuEntity ||--o{ AddressEntity : "1对多"
    YonghuEntity ||--o{ StoreupEntity : "1对多"
    YonghuEntity ||--o{ DiscussshangpinxinxiEntity : "1对多"
    YonghuEntity ||--o{ ChatEntity : "1对多"
    
    ShangpinxinxiEntity ||--o{ OrdersEntity : "1对多"
    ShangpinxinxiEntity ||--o{ CartEntity : "1对多"
    ShangpinxinxiEntity ||--o{ StoreupEntity : "1对多"
    ShangpinxinxiEntity ||--o{ DiscussshangpinxinxiEntity : "1对多"
    
    ShangpinleixingEntity ||--o{ ShangpinxinxiEntity : "1对多"
    
    UserEntity ||--o{ ChatEntity : "1对多"
    UserEntity ||--o{ TokenEntity : "1对多"
```

### 2. 用户下单流程时序图

```
sequenceDiagram
    participant U as 用户
    participant FC as 前端控制器
    participant OC as OrdersController
    participant OS as OrdersService
    participant CS as CartService
    participant AS as AddressService
    participant DB as 数据库
    
    U->>FC: 提交订单请求
    FC->>OC: POST /orders/add
    OC->>OS: 创建订单
    OS->>CS: 获取购物车信息
    CS->>DB: 查询购物车
    DB-->>CS: 返回购物车数据
    CS-->>OS: 购物车信息
    OS->>AS: 获取收货地址
    AS->>DB: 查询地址
    DB-->>AS: 返回地址数据
    AS-->>OS: 地址信息
    OS->>OS: 计算订单总价
    OS->>OS: 生成订单编号
    OS->>DB: 插入订单记录
    DB-->>OS: 订单创建成功
    OS->>CS: 清空购物车
    CS->>DB: 删除购物车记录
    DB-->>CS: 删除成功
    CS-->>OS: 购物车已清空
    OS-->>OC: 返回订单结果
    OC-->>FC: 返回响应
    FC-->>U: 订单提交成功
```

### 3. 用户登录流程时序图

```
sequenceDiagram
    participant U as 用户
    participant FC as 前端
    participant YC as YonghuController
    participant YS as YonghuService
    participant TS as TokenService
    participant DB as 数据库
    
    U->>FC: 输入账号密码
    FC->>YC: POST /yonghu/login
    YC->>YS: 验证用户信息
    YS->>DB: 查询用户
    DB-->>YS: 返回用户数据
    YS->>YS: 验证密码
    alt 密码正确
        YS->>TS: 生成Token
        TS->>TS: 生成令牌
        TS->>DB: 保存Token
        DB-->>TS: 保存成功
        TS-->>YS: 返回Token
        YS-->>YC: 登录成功+Token
        YC-->>FC: 返回Token
        FC-->>U: 登录成功
    else 密码错误
        YS-->>YC: 登录失败
        YC-->>FC: 返回错误信息
        FC-->>U: 账号或密码不正确
    end
```

### 4. 系统顶层数据流图

```
flowchart TD
    A[用户] -->|商品浏览请求| B[秒杀系统]
    A -->|订单提交| B
    A -->|购物车操作| B
    A -->|用户注册/登录| B
    
    C[管理员] -->|商品管理| B
    C -->|订单管理| B
    C -->|用户管理| B
    
    B -->|商品数据| D[(商品数据库)]
    B -->|订单数据| E[(订单数据库)]
    B -->|用户数据| F[(用户数据库)]
    
    B -->|响应数据| A
    B -->|管理数据| C
```

### 5. 秒杀活动流程活动图

```
stateDiagram-v2
    [*] --> 浏览商品
    浏览商品 --> 查看商品详情
    查看商品详情 --> 加入购物车
    加入购物车 --> 查看购物车
    查看购物车 --> 选择收货地址
    选择收货地址 --> 提交订单
    提交订单 --> 验证库存
    验证库存 --> 库存充足: 是
    验证库存 --> 库存不足: 否
    库存不足 --> [*]
    库存充足 --> 计算金额
    计算金额 --> 生成订单
    生成订单 --> 扣减库存
    扣减库存 --> 清空购物车
    清空购物车 --> 订单完成
    订单完成 --> [*]
```

### 6. 用户注册登录活动图

```
stateDiagram-v2
    [*] --> 访问系统
    访问系统 --> 选择登录
    访问系统 --> 选择注册
    选择注册 --> 填写注册信息
    填写注册信息 --> 验证信息
    验证信息 --> 信息有效: 是
    验证信息 --> 信息无效: 否
    信息无效 --> 填写注册信息
    信息有效 --> 创建用户
    创建用户 --> 注册成功
    注册成功 --> 选择登录
    选择登录 --> 输入账号密码
    输入账号密码 --> 验证用户
    验证用户 --> 验证成功: 是
    验证用户 --> 验证失败: 否
    验证失败 --> 输入账号密码
    验证成功 --> 生成Token
    生成Token --> 登录成功
    登录成功 --> 进入系统
    进入系统 --> [*]
```

---

## 使用步骤

1. **打开网站**：访问 https://mermaid.live/
2. **复制代码**：从上面的代码块中复制（**不要包含** ```mermaid 和 ```）
3. **粘贴代码**：粘贴到左侧的编辑框中
4. **查看结果**：右侧会自动显示渲染后的图表
5. **导出图片**：点击右上角的 "Actions" → "Download PNG" 或 "Download SVG"

---

## 常见问题

### Q: 为什么复制后没有显示？
A: 检查是否包含了 ```mermaid 标记，只复制代码块内的内容。

### Q: 图表显示不完整？
A: 某些复杂的图表可能需要简化，或者检查语法是否正确。

### Q: 如何导出为图片？
A: 在 mermaid.live 网站右上角点击 "Actions" → 选择 "Download PNG" 或 "Download SVG"

### Q: 可以在Word中使用吗？
A: 可以，先导出为PNG图片，然后插入到Word文档中。

---

## 提示

- 每个图表代码都是独立的，可以单独复制使用
- 如果某个图表太大，可以拆分成多个小图表
- 建议先测试简单的图表，确认网站正常工作后再复制复杂图表
