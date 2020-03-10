package io.mycat.upondb;

import io.mycat.Identical;
import io.mycat.api.collector.RowBaseIterator;
import io.mycat.api.collector.UpdateRowIterator;
import io.mycat.metadata.LogicTable;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public interface MycatDBClientBased {

    MycatDBSharedServer getUponDBSharedServer();

    Map<String, Map<String, LogicTable>> config();

    Map<String, Object> variables();

    <T> T getCache(Identical key, String targetName, String sql, List<Object> params);

    void cache(Identical key, String targetName, String sql, List<Object> params, Object o);

    <T> T removeCache(Identical key, String targetName, String sql, List<Object> params);

    RowBaseIterator prepareQuery(String targetName, String sql, List<Object> params);

    UpdateRowIterator prepareUpdate(String targetName, String sql, List<Object> params);

    UpdateRowIterator update(String targetName, String sql);

    RowBaseIterator query(String targetName, String sql);

    UpdateRowIterator update(String targetName, List<String> sqls);

    void begin();

    void rollback();

    void commit();

    void setTransactionIsolation(int value);

    int getTransactionIsolation();

    boolean isAutocommit();

    void setAutocommit(boolean autocommit);

    void close();

    AtomicBoolean cancleFlag();
}