# ToDoAPI

## 概要
**ToDoAPI** は、Spring Boot と MyBatis を使用して構築されたシンプルな RESTful API です。タスク管理アプリケーションとして、タスクの作成、取得、更新、削除を行うことができます。データベースには MySQL を使用しています。

作成目的としては、モックアップやフロントエンドアプリケーションの開発に役立つことを目指しています。

## 機能
- タスクの作成 (POST)
- タスクの一覧取得 (GET)
- 特定のタスクの取得 (GET)
- タスクの更新 (PUT)
- タスクの削除 (DELETE)

## 使用技術
- Java 17+
- Spring Boot
- MyBatis
- MySQL
- Lombok

## 前提条件
- **Java 17** 以上がインストールされていること
- **MySQL** がインストールされ、データベースがセットアップされていること
- **Maven** がインストールされていること

## セットアップ

### 1. リポジトリのクローン
```bash
git clone https://github.com/yourusername/todoapi.git
cd todoapi
```

### 2. MySQL データベースのセットアップ
MySQL にログインして、データベースを作成します。

```sql
CREATE DATABASE todo_db;
```

次に、以下のコマンドで `todos` テーブルを作成します。

```sql
CREATE TABLE todos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    task VARCHAR(300) NOT NULL,
    completed BOOLEAN NOT NULL DEFAULT FALSE
);
```

### 3. 環境変数または `.env` ファイルの設定
データベース接続情報を `.env` ファイルに追加します。プロジェクトルートに `.env` ファイルを作成し、以下の情報を追加してください。

```bash
DB_URL=jdbc:mysql://localhost:3306/todo_db
DB_USERNAME=root
DB_PASSWORD=yourpassword
```

### 4. プロジェクトのビルドと実行
プロジェクトのディレクトリで以下のコマンドを実行して、Spring Boot アプリケーションを起動します。

```bash
mvn clean install
mvn spring-boot:run
```

アプリケーションが起動したら、`http://localhost:8080` で API にアクセスできます。

## API エンドポイント

### 1. **GET /api/todos**
すべてのタスクを取得します。

```bash
curl -X GET http://localhost:8080/api/todos
```

### 2. **GET /api/todos/{id}**
指定したIDのタスクを取得します。

```bash
curl -X GET http://localhost:8080/api/todos/1
```

### 3. **POST /api/todos**
新しいタスクを作成します。

```bash
curl -X POST http://localhost:8080/api/todos \
-H "Content-Type: application/json" \
-d '{
  "task": "Buy groceries",
  "completed": false
}'
```

### 4. **PUT /api/todos/{id}**
指定したIDのタスクを更新します。

```bash
curl -X PUT http://localhost:8080/api/todos/1 \
-H "Content-Type: application/json" \
-d '{
  "task": "Update groceries",
  "completed": true
}'
```

### 5. **DELETE /api/todos/{id}**
指定したIDのタスクを削除します。

```bash
curl -X DELETE http://localhost:8080/api/todos/1
```

## テスト
JUnit を使用してアプリケーションの単体テストを実行できます。

```bash
mvn test
```

## 貢献方法
バグレポートや機能のリクエスト、コードの改善提案など、貢献を歓迎しています。プルリクエストを送る前に、問題を開いて話し合いをすることをお勧めします。

