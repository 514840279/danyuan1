-- ����date�ı� Ҫ�޸ĳ�date�е�
select * from vw_table_column_comments t
where t.������ in( '���ʱ��')
and t.������<> 'DATE' 
and t.������ not like 'TPL%';

-- ��date�ı� �޸�varchar ��
select * from vw_table_column_comments t
where 1=1
--and t.column_name in( 'STIME','INSERT_DATE','UPDATE_DATE','��������','�ɼ�ʱ��','����ʱ��')
and t.������= 'DATE'
and t.������ not in('���ʱ��');

