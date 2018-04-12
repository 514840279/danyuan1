--1���鿴��ռ�����Ƽ���С 
select 
b.file_id �ļ�ID��, 
b.tablespace_name ��ռ���, 
b.bytes/1024/1024||'M'�ֽ���, 
(b.bytes-sum(nvl(a.bytes,0)))/1024/1024||'M' ��ʹ��, 
sum(nvl(a.bytes,0))/1024/1024||'M' ʣ��ռ�, 
100 - sum(nvl(a.bytes,0))/(b.bytes)*100 ռ�ðٷֱ� 
from dba_free_space a,dba_data_files b 
where a.file_id=b.file_id 
group by b.tablespace_name,b.file_id,b.bytes 
order by b.file_id; 

--1���鿴��ռ�����Ƽ���С 
select sum (ts_size)||'M' from (
SELECT t.tablespace_name, round(SUM(bytes / (1024 * 1024)), 0) ts_size 
FROM dba_tablespaces t, dba_data_files d 
WHERE t.tablespace_name = d.tablespace_name 
GROUP BY t.tablespace_name); 

--2���鿴��ռ������ļ������Ƽ���С 
SELECT tablespace_name, 
file_id, 
file_name, 
round(bytes / (1024 * 1024), 0) total_space 
FROM dba_data_files 
ORDER BY tablespace_name; 


--6���鿴��ռ��ʹ����� 
SELECT SUM(bytes) / (1024 * 1024) AS free_space, tablespace_name 
FROM dba_free_space 
GROUP BY tablespace_name; 
SELECT a.tablespace_name, 
a.bytes total, 
b.bytes used, 
c.bytes free, 
(b.bytes * 100) / a.bytes "% USED ", 
(c.bytes * 100) / a.bytes "% FREE " 
FROM sys.sm$ts_avail a, sys.sm$ts_used b, sys.sm$ts_free c 
WHERE a.tablespace_name = b.tablespace_name 
AND a.tablespace_name = c.tablespace_name; 


--9���鿴���ݿ�Ĵ������ں͹鵵��ʽ 
SELECT created, log_mode, log_mode FROM v$database; 
--1G=1024MB 
--1M=1024KB 
--1K=1024Bytes 
--1M=11048576Bytes 
--1G=1024*11048576Bytes=11313741824Bytes 
SELECT a.tablespace_name "��ռ���", 
total "��ռ��С", 
free "��ռ�ʣ���С", 
(total - free) "��ռ�ʹ�ô�С", 
total / (1024 * 1024 * 1024) "��ռ��С(G)", 
free / (1024 * 1024 * 1024) "��ռ�ʣ���С(G)", 
(total - free) / (1024 * 1024 * 1024) "��ռ�ʹ�ô�С(G)", 
round((total - free) / total, 4) * 100 "ʹ���� %" 
FROM (SELECT tablespace_name, SUM(bytes) free 
FROM dba_free_space 
GROUP BY tablespace_name) a, 
(SELECT tablespace_name, SUM(bytes) total 
FROM dba_data_files 
GROUP BY tablespace_name) b 
WHERE a.tablespace_name = b.tablespace_name ;


-- Ϊ���ݿ���ӱ�ռ䣨�����ļ���
ALTER TABLESPACE ZHCX_DATA ADD DATAFILE
'D:\APP\ADMINISTRATOR\ORADATA\ORCL\ZHCX_DATA010.ORA' SIZE 50M
AUTOEXTEND ON NEXT 5M MAXSIZE 30000M;
