querydsl-support
================

Functional interfaces that makes easier to make database access with Querydsl. Module contains reference 
implementation.

## Usage with Java 7

```
return querydslSupport.execute(new QuerydslCallable<Long>() {
     @Override
     public Long call(Connection connection, Configuration configuration) throws SQLException {
        QResource qResource = new QResource("qResource");
        SQLInsertClause insertClause = new SQLInsertClause(connection, configuration, qResource);
        return insertClause.executeWithKey(qResource.resourceId);
    }
});
```

## Usage with Java 8

```
return querydslSupport.execute((connection, configuration) -> {
    QResource qResource = new QResource("qResource");
    SQLInsertClause insertClause = new SQLInsertClause(connection, configuration, qResource);
    return insertClause.executeWithKey(qResource.resourceId);
});
```

[![Analytics](https://ga-beacon.appspot.com/UA-15041869-4/everit-org/querydsl-support)](https://github.com/igrigorik/ga-beacon)
