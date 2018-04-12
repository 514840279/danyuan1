select count(table_name) as ���б������
  from (select t.table_name, tc.comments, t.num_rows
          from user_tables t
         inner join user_tab_comments tc on t.table_name = tc.table_name
         where t.table_name not like '%$%');

select count(table_name) as ע�ͱ�����ı���
  from (select t.table_name, tc.comments, t.num_rows
          from user_tables t
         inner join user_tab_comments tc on t.table_name = tc.table_name
         where t.table_name not like '%$%'
           and (tc.comments is not null or
               length(t.table_name) <> lengthb(t.table_name)));

select count(*) as ���е���
  from (select t.TABLE_NAME, t.COLUMN_NAME, cc.comments
          from user_tab_columns t
         inner join user_col_comments cc on t.TABLE_NAME = cc.table_name
                                        and t.COLUMN_NAME = cc.column_name
         where t.table_name not like '%$%');

select count(*) as ��ע�͵Ļ�������
  from (select t.TABLE_NAME, t.COLUMN_NAME, cc.comments
          from user_tab_columns t
         inner join user_col_comments cc on t.TABLE_NAME = cc.table_name
                                        and t.COLUMN_NAME = cc.column_name
         where t.table_name not like '%$%'
           and (cc.comments is not null or
               length(cc.column_name) <> lengthb(cc.column_name)));

select (select count(table_name) as ��ע�ͱ�����
          from (select t.table_name, tc.comments, t.num_rows
                  from user_tables t
                 inner join user_tab_comments tc on t.table_name =
                                                    tc.table_name
                 where t.table_name not like '%$%') -
                select count(table_name) as ��ע�ͱ�����
                  from (select distinct t.table_name
                          from user_tables t
                         inner join user_tab_comments tc on t.table_name =
                                                            tc.table_name
                         inner join user_tab_columns c on t.table_name =
                                                          c.TABLE_NAME
                                                      and tc.table_name =
                                                          c.TABLE_NAME
                         inner join user_col_comments cc on c.TABLE_NAME =
                                                            cc.table_name
                                                        and c.COLUMN_NAME =
                                                            cc.column_name
                         where t.table_name not like '%$%'
                           and (tc.comments is null and
                               length(t.table_name) = lengthb(t.table_name))
                            or (cc.comments is null and
                               length(cc.column_name) =
                               lengthb(cc.column_name)))
        ) as ��ȫע�͵ı�����ĵı�
  from dual;
