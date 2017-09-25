package br.com.alert.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.alert.ConnectionFactory;
import br.com.alert.modelo.Relatorio;




public class RelatorioDAO {
	
	private Connection conexao;
	
	
	public RelatorioDAO(){
		try {
			this.conexao = new ConnectionFactory().getConnection();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			// TODO: handle exception
		}
	}
	
// Lista relat�rio
	
	public List<Relatorio> relatorioList(){
		try {
			List<Relatorio> relatorios = new ArrayList<Relatorio>();
			PreparedStatement stm = this.conexao.prepareStatement("select a.*, b.nom_setor,c.exc_dom,c.exc_seg,c.exc_ter,c.exc_qua,"
					+ "c.exc_qui,c.exc_sex,c.exc_sab, c.exc_hr_00,c.exc_hr_01,c.exc_hr_02,c.exc_hr_03,c.exc_hr_04,c.exc_hr_05,"
					+ "c.exc_hr_06,c.exc_hr_07,c.exc_hr_08,c.exc_hr_09,c.exc_hr_10,c.exc_hr_11,c.exc_hr_12,c.exc_hr_13,c.exc_hr_14,"
					+ "c.exc_hr_15,c.exc_hr_16,c.exc_hr_17,c.exc_hr_18,c.exc_hr_19,c.exc_hr_20,c.exc_hr_21,c.exc_hr_22,c.exc_hr_23 from tcc_relatorio a, tcc_setor b, tcc_execucao c "
					+ "where a.cod_setor = b.cod_setor"
					+ " and a.cod_sub_setor = b.cod_sub_setor"
					+ " and a.cod_setor = c.cod_setor "
					+ " and a.cod_sub_setor = c.cod_sub_setor"
					+ " and a.cod_relatorio = c.cod_relatorio"
					+ " and b.ind_ativo = 'S' order by a.dat_criacao desc, a.cod_relatorio");
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				
			relatorios.add(populaRelatorio(rs));
				}
				
			
			
			rs.close();
			stm.close();
			conexao.close();
			

			return relatorios;
			
		} catch (SQLException e ) {
			throw new RuntimeException(e);
			// TODO: handle exception
		}
		
		
	}
	
	public Relatorio populaRelatorio(ResultSet rs) throws SQLException{
		
		Relatorio relatorio = new Relatorio();
		
		relatorio.setCod_setor(rs.getLong("cod_setor"));
		relatorio.setCod_sub_setor(rs.getLong("cod_sub_setor"));
		relatorio.setCod_relatorio(rs.getLong("cod_relatorio"));
		relatorio.setCod_contato(rs.getLong("cod_contato"));
		Date data = rs.getDate("dat_criacao");
		if (data != null) {
			Calendar dat_criacao = Calendar.getInstance();
			dat_criacao.setTime(data);
			relatorio.setDat_criacao(dat_criacao);
		}
		Date dataAl = rs.getDate("dat_alteracao");
		if(dataAl != null){
			Calendar dat_alteracao = Calendar.getInstance();
			dat_alteracao.setTime(dataAl);
			relatorio.setDat_alteracao(dat_alteracao);
		}
		relatorio.setNom_setor(rs.getString("nom_setor"));
		relatorio.setInd_ativo(rs.getString("ind_ativo"));
		relatorio.setInd_senha(rs.getString("ind_senha"));
		relatorio.setInd_anexo(rs.getString("ind_anexo"));
		relatorio.setInd_web(rs.getString("ind_web"));
		relatorio.setInd_anexo(rs.getString("ind_texto"));
		relatorio.setRel_nome(rs.getString("rel_nome"));
		relatorio.setRel_assunto(rs.getString("rel_assunto"));
		relatorio.setRel_titulo(rs.getString("rel_titulo"));
		relatorio.setRel_introducao(rs.getString("rel_introducao"));
		relatorio.setRel_sql_filtro(rs.getString("rel_sql_filtro"));
		relatorio.setRel_sql(rs.getString("rel_sql"));
		relatorio.setRel_texto(rs.getString("rel_texto"));
		relatorio.setRel_rodape(rs.getString("rel_rodape"));
		relatorio.setRel_descricao(rs.getString("rel_descricao"));
		relatorio.setDesenvolvedor_nome(rs.getString("desenvolvedor_nome"));
		relatorio.setDesenvolvedor_email(rs.getString("desenvolvedor_email"));
		relatorio.setAgenda(rs.getString("agenda"));
		
		relatorio.setExc_dom(rs.getString("exc_dom"));
		relatorio.setExc_seg(rs.getString("exc_seg"));
		relatorio.setExc_ter(rs.getString("exc_ter"));
		relatorio.setExc_qua(rs.getString("exc_qua"));
		relatorio.setExc_qui(rs.getString("exc_qui"));
		relatorio.setExc_sex(rs.getString("exc_sex"));
		relatorio.setExc_sab(rs.getString("exc_sab"));	
		
		relatorio.setExc_hr_00(rs.getString("exc_hr_00"));
		relatorio.setExc_hr_01(rs.getString("exc_hr_01"));
		relatorio.setExc_hr_02(rs.getString("exc_hr_02"));
		relatorio.setExc_hr_03(rs.getString("exc_hr_03"));
		relatorio.setExc_hr_04(rs.getString("exc_hr_04"));
		relatorio.setExc_hr_05(rs.getString("exc_hr_05"));
		relatorio.setExc_hr_06(rs.getString("exc_hr_06"));
		relatorio.setExc_hr_07(rs.getString("exc_hr_07"));
		relatorio.setExc_hr_08(rs.getString("exc_hr_08"));
		relatorio.setExc_hr_09(rs.getString("exc_hr_09"));
		relatorio.setExc_hr_10(rs.getString("exc_hr_10"));
		relatorio.setExc_hr_11(rs.getString("exc_hr_11"));
		relatorio.setExc_hr_12(rs.getString("exc_hr_12"));
		relatorio.setExc_hr_13(rs.getString("exc_hr_13"));
		relatorio.setExc_hr_14(rs.getString("exc_hr_14"));
		relatorio.setExc_hr_15(rs.getString("exc_hr_15"));
		relatorio.setExc_hr_16(rs.getString("exc_hr_16"));
		relatorio.setExc_hr_17(rs.getString("exc_hr_17"));
		relatorio.setExc_hr_18(rs.getString("exc_hr_18"));
		relatorio.setExc_hr_19(rs.getString("exc_hr_19"));
		relatorio.setExc_hr_20(rs.getString("exc_hr_20"));
		relatorio.setExc_hr_21(rs.getString("exc_hr_21"));
		relatorio.setExc_hr_22(rs.getString("exc_hr_22"));
		relatorio.setExc_hr_23(rs.getString("exc_hr_23"));
				
		
		
		return relatorio;
		
	}
	
	//Buscar relat�rio por c�digo
	
	public Relatorio buscaPorId(Relatorio rel) {
		System.out.println(rel.getCod_relatorio());
		System.out.println(rel.getCod_setor());
		
		String sql = "select * from TCC_RELATORIO where cod_relatorio = ? and cod_setor = ?";
		PreparedStatement stm;
		try {
			stm = conexao.prepareStatement(sql);
			stm.setLong(1, rel.getCod_relatorio());
			stm.setLong(2, rel.getCod_setor());
			
			ResultSet rs = stm.executeQuery();
			
			if (rs.next()) {
				return populaRelatorio(rs);
			}

			rs.close();
			stm.close();
			
			

			
			return null;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
		
		//Cadastrar Relat�rio no banco
		
		public void insereRelatorio(Relatorio rel) {	
			
			String sql = "INSERT INTO TCC_RELATORIO(cod_setor,cod_sub_setor, cod_relatorio, cod_contato, dat_criacao, dat_alteracao,"
					+ "ind_ativo, ind_senha, ind_anexo, ind_web, ind_texto, rel_nome, rel_assunto, rel_titulo, rel_introducao, rel_sql_filtro,"
					+ "rel_sql, rel_texto, rel_rodape, rel_descricao, desenvolvedor_nome, desenvolvedor_email, agenda) "
					+ "VALUES(?,1,(Select nvl(max(a.cod_relatorio),0) + 1 from tcc_relatorio a where a.cod_setor = ? and a.cod_sub_setor = 1),?,?,?,"
					+ "'N',null,?,?,?,?,?,?,?,null,"
					+ "null,?,?,?,?,?,?)";
				PreparedStatement stm;	
				
						
			try {
				stm=conexao.prepareStatement(sql);
				stm.setLong(1, rel.getCod_setor());
				stm.setLong(2, rel.getCod_setor());
				stm.setLong(3, rel.getCod_contato());
				stm.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));
				stm.setDate(5, new Date(Calendar.getInstance().getTimeInMillis()));
				stm.setString(6, rel.getInd_anexo());
				stm.setString(7, rel.getInd_web());
				stm.setString(8, rel.getInd_texto());
				stm.setString(9, rel.getRel_nome());
				stm.setString(10, rel.getRel_assunto());
				stm.setString(11, rel.getRel_titulo());
				stm.setString(12, rel.getRel_introducao());
				stm.setString(13, rel.getRel_texto());
				stm.setString(14, rel.getRel_rodape());
				stm.setString(15, rel.getRel_descricao());
				stm.setString(16, rel.getDesenvolvedor_nome());
				stm.setString(17, rel.getDesenvolvedor_email());
				stm.setString(18, rel.getAgenda());
				stm.execute();
				
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}		
		}

		
		//Inserir Quary no Relat�rio
	
	public void alterarRelatorio(Relatorio rel){
		String sql = "update TCC_RELATORIO SET REL_SQL = ?, "
				+ "ind_ativo = 'S', dat_alteracao = ? WHERE COD_SETOR = ? AND COD_SUB_SETOR = 1 AND COD_RELATORIO = ?";
		PreparedStatement stm;
		try {
			stm = conexao.prepareStatement(sql);
			stm.setString(1, rel.getRel_sql());
			stm.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
			stm.setLong(3, rel.getCod_setor());
			stm.setLong(4, rel.getCod_relatorio());
			stm.execute();
			stm.close();
			conexao.commit();
			conexao.close();
			
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			// TODO: handle exception
		}
	}
	
	
	// Alterar relat�rio ativo ou inativo.
	public void statusRelatorio(Relatorio rel){
		String sql = "update TCC_RELATORIO set dat_alteracao = ?, ind_ativo = decode(ind_ativo,'S','N','S') "
				+ "WHERE COD_SETOR = ? AND COD_SUB_SETOR = 1 AND COD_RELATORIO = ?";
		PreparedStatement stm;
		try {
			stm = conexao.prepareStatement(sql);
			stm.setDate(1, new Date(Calendar.getInstance().getTimeInMillis()));
			stm.setLong(2, rel.getCod_setor());
			stm.setLong(3, rel.getCod_relatorio());
			stm.execute();
			stm.close();
			conexao.commit();
			conexao.close();
		
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			// TODO: handle exception
		}
	}
	
	// Remover relat�rio do Banco.
	
	public void removeRelatorio(Relatorio rel){
		String sql = "delete from TCC_RELATORIO where COD_RELATORIO = ? and COD_SETOR = ?";
		PreparedStatement stm;
		try {
			stm = conexao.prepareStatement(sql);
			stm.setLong(1, rel.getCod_relatorio());
			stm.setLong(2, rel.getCod_setor());
			stm.execute();
			stm.close();
			conexao.close();
			
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			// TODO: handle exception
		}
	}	
	
	

}
	


