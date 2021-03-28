package delta.agriculture.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor


public class Exigible  {
    /**
	 * 
	 */
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long paysan;
    private Long numero;
    private Long numero_membre;
    private String cout_hydrolique;
    private Long quantitehydrolique;
    private Long PUhydrolique;
    private Long montanthydrolique;
    private String offset1;
    private Long quantiteoffet1;
    private Long PUoffset1;
    private Long montantoffset1;
    private String offset2;
    private Long quantiteoffet2;
    private Long PUoffset2;
    private Long montantoffset2;
    private String semence;
    private Long quantiteSemence;
    private Long PUsemence;
    private Long montantsemence;
    private String uree;
    private Long quantiteuree;
    private Long PUuree;
    private Long montanturee;
    private String Dap;
    private Long quantiteDap;
    private Long PUDap;
    private Long montantDap;
    private String Propanil;
    private Long quantitePropanil;
    private Long PUPropanil;
    private Long montantPropanil;
    private String weedone;
    private Long quantiteWeedone;
    private Long PUWeedone;
    private Long montantWeedone;
    private String granite;
    private Long quantiteGranite;
    private Long PUGranite;
    private Long montantGranite;
    private String londax;
    private Long quantiteLondax;
    private Long PULondax;
    private Long montantLondax;
    private String glyphader;
    private Long quantiteGlyphader;
    private Long PUGlyphader;
    private Long montantGlyphader;
    private String sacherie;
    private Long quantiteSacherie;
    private Long PUSacherie;
    private Long montantSacherie;
    private String pulverisateur;
    private Long quantitePulverisateur;
    private Long PUPulverisateur;
    private Long montantPulverisateur;
    private String fomaed;
    private Long quantiteFomaed;
    private Long PUFomaed;
    private Long montantFomaed;
    private String omvs;
    private Long quantiteOmvs;
    private Long PUOmvs;
    private Long montantOmvs;
    private String assurance;
    private Long quantiteAssurance;
    private Long PUAssurance;
    private Long montantAssurance;
    private String cocger;
    private Long quantiteCoceger;
    private Long PUCoceger;
    private Long montantCoceger;
    private String frais_recolte;
    private Long quantiteFrais_recolte;
    private Long PUFrais_recolte;
    private Long montantFrais_Recolte;
    private String interets_bancaire;
    private Long quantiteInterets_bancaire;
    private Long PUInteret_bancaire;
    private Long montantInteret_bancaire;
    private String son_riz;
    private Long quantiteSon_riz;
    private Long PUSon_riz;
    private Long montantSon_riz;
    private String Gestionnaire;
    private Long quantiteGestionnaire;
    private Long PUGestionnaire;
    private Long montantGestionnaire;
    private String responsable_credit;
    private Long quantiteResponsable_credit;
    private Long PUResponsable_credit;
    private Long montantResponsable_credit;
    private String peseur;
    private Long quantitePEseur;
    private Long PUPeseur;
    private Long montantPeseur;
    private String transp_manutention;
    private Long quantitetransp_manutention;
    private Long PUtransp_manutention;
    private Long montanttransp_manutention;
    private String receptionniste;
    private Long quantiteReceptionniste;
    private Long PUReceptionniste;
    private Long montantReceptionniste;
    private String frais_dossier;
    private Long quantiteFrais_dossier;
    private Long PUFrais_dossier;
    private Long montantFrais_dossier;
    private String amende;
    private Long quantiteAmende;
    private Long PUAmende;
    private Long montantAmende;
    private Long total_charge_campagne;
    private Long Arriere;
    private Long Avance;
    private Long Total_Creance;
    private Long CreditJC;
    private String A_deposer;
    private Long Prix_collete;
    private Long poids;
    private Long nbreSac;

    
    @JsonIgnore
    @ManyToOne @JoinColumn(name="idSaison", nullable=false)
    private Saison saison;


}
