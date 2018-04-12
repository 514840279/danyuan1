-- 1 Ŀ�����ݿ���link   Ԫ���ݿ�
create database link DBLINK_172_16_3_5
  connect to ZHCX identified by zhcx
  using '(DESCRIPTION =
          (ADDRESS_LIST =
            (ADDRESS = (PROTOCOL = TCP)(HOST = 172.16.3.5)(PORT = 1521))
          )
          (CONNECT_DATA =
            (SERVER = DEDICATED)
            (SERVICE_NAME = orcl)
          )
        )';
-- 2 Ԫ���ݿ� ��������� ������䵽Ŀ�����ݿ���ִ��
select  'create table '||t.table_name ||' tablespace ZHCX_GAXX_DATA as select * from '||t.table_name||'@dblink_172_16_3_5;
commit;' from user_tables t
where t.tablespace_name = 'ZHCX_GAXX_DATA' and t.table_name not like '%$%'

select  'create table '||t.table_name ||' tablespace ZHCX_GSXX_DATA as select * from '||t.table_name||'@dblink_172_16_3_5;
commit;' from user_tables t
where t.tablespace_name = 'ZHCX_GSXX_DATA' and t.table_name not like '%$%'
;

-- 3 ���� ��ע�����
select 'comment on table '||t.table_name||'  is '''||t.comments||''';' from user_tab_comments t where t.comments is not null and t.table_name not like '%$%';

-- 4 ������ע�����
select 'comment on column '||t.table_name||'.'||t.column_name||'  is '''||t.comments||''';' from user_col_comments t where t.comments is not null and t.table_name not like '%$%';


-- 5 ��ͼ�����̣������� Ǩ�� ���´���
����sql���ȥ ִ��

--  6 ����Ǩ�����
select 'create index '||t.index_name||' on '||t.table_name||' ('||wm_concat(t.column_name||' '||t.descend)||') tablespace ZHCX_LGYXX_INDEX;' from user_ind_columns t group by t.table_name,t.index_name;





-- ��������
select
'create index ix_'||trim(t.table_uuid)||'_'||t.cols_name||' on '||tt.table_name||' ('||t.cols_name||') tablespace ZHCX_INDEX',
 trim(t.table_uuid),t.* from sys_zhcx_cols t
left join sys_zhcx_tabs tt on t.table_uuid = tt.uuid
where t.user_index is not null 
and trim(t.table_uuid) not in(select owner||'_'||table_name from all_indexes );