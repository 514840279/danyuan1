-- ��ѯ���� 
-- ��ѯΪ�����ļ���Ϣ
select t.*, t.rowid
  from sys_lrd_filelist t
 where 1 = 1
   and t.stateflag not in ('3', '10')
--and t.filename not like'%��ҵ_�ɶ���Ϣ%'
--and t.stateflag = '3'
--and t.update_time > sysdate -1
 order by t.date1;

-- ��ѯ������ļ��γɵ� insert �����
select t.*, t.rowid
  from sys_lrd_mapping_log t
 where t.exe_start_time > sysdate - 1
   and t.exe_count is null
 order by t.exe_start_time desc;

--�鿴���ϵͳ��־

-- �鿴������ص���Щrar�ļ�
select replace(substr(t.oldfile, instr(t.oldfile, '\', 1, 5) + 1, 3), '\') as name,
       substr(t.oldfile, instr(t.oldfile, '\', 1, 6) + 1, 8) as datet,
       t.*,
       t.rowid
  from sys_lrd_oldrar t
 where 1 = 1
   --and t.flag <> '2'
   and date1>sysdate-1
   and t.oldfile not like '%html%'
 order by date1 desc;

-- ��ѯ��ϵӳ��
select t.*, t.rowid
  from sys_lrd_cols_map t
 where 1 = 1
      --and t.tab_name = 'SHXX_SWXG_FPXG_��Ʊ��Ϣ'
   and t.tab_col is null
   and t.tab_name is null;

-- ��ѯ�����Ϣ
select *
  from aaa_�����־ t
 where t.¼��ʱ�� > sysdate - 1
 order by t.¼��ʱ�� desc;

-- �鿴������ļ���Ϣ
select t.*, t.rowid
  from sys_lrd_errordatefile t
 where t.flag not in ('3', '10')
   and t.inset_date > sysdate - 1;

-- ����ͳ��
select *
  from sys_zhcx_analyst t
 where t.ͳ������ = to_char(sysdate - 1, 'YYYY-MM-DD')
   and t.�������� > 0;

select oldfile
  from sys_lrd_oldrar t
 where flag <> '2'
   and t.oldfile not like '%html%';

-- IPC ͳ�Ʊ���
SELECT (A / B * 100) || '%'
  FROM (select COUNT(*) AS A from sys_classify_ר��ipc t where t.flag = '1'),
       (select COUNT(*) AS B from sys_classify_ר��ipc t)
