<?xml version="1.0" encoding="ISO-8859-1"?>
 
<!-- 	(c) GNU General Public License
	Author: Benno Luthiger, Aktion HIP, Switzerland
-->
  
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" encoding="ISO-8859-1"/>

<xsl:template match="/">
<form name="Form" action="servlet" method="post">
<input type="hidden" name="requestType" value="savePretest"/>
	<xsl:apply-templates select="Root/Questions/QuestionnairePre/propertySet"/>
</form>
</xsl:template>

<xsl:template match="propertySet">
<table>
  <tr>
    <td colspan="13">
      <img src="./images/logo_mini_eng.png" alt="University of Zurich" align="right"/>
      <h2><xsl:value-of select="$TitleLbl"/></h2>
    </td>
  </tr>
  <tr>
    <td colspan="2" class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
    <td colspan="10" class="pretest">
	<xsl:value-of select="$RemarkLbl"/>
    </td>
    <td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
  </tr>

<tr class="comment">
<td colspan="2"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="bordered" colspan="2"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td>---</td>
<td>--</td>
<td>-</td>
<td>+</td>
<td>++</td>
<td>+++</td>
<td colspan="3"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
</tr>

<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">1</td>
<td class="bordered"><xsl:value-of select="$q1Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q1"/>
</xsl:call-template>
<td class="odd inverseLabel">1</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">1</td>
<td class="bordered"><xsl:value-of select="$q1pre_Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q1_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">1</td>
</tr>
  <tr>
    <td colspan="4" class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
</td>
	<td>---</td>
	<td>--</td>
	<td>-</td>
	<td>+</td>
	<td>++</td>
	<td>+++</td>
	<td colspan="3"/>	
  </tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">3</td>
<td class="bordered"><xsl:value-of select="$q3Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q3"/>
</xsl:call-template>
<td class="odd inverseLabel">3</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">3</td>
<td class="bordered"><xsl:value-of select="$q3pre_Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q3_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">3</td>
</tr>
  <tr>
    <td colspan="4" class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
</td>
	<td>---</td>
	<td>--</td>
	<td>-</td>
	<td>+</td>
	<td>++</td>
	<td>+++</td>
	<td colspan="3"/>	
  </tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">5</td>
<td class="bordered"><xsl:value-of select="$q5Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q5"/>
</xsl:call-template>
<td class="odd inverseLabel">5</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">5</td>
<td class="bordered"><xsl:value-of select="$why1Lbl"/><xsl:call-template name="value_checkbox"><xsl:with-param name="question" select="q5"/></xsl:call-template><xsl:value-of select="$why2Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q5_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">5</td>
</tr>
  <tr>
    <td colspan="4" class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
</td>
	<td>---</td>
	<td>--</td>
	<td>-</td>
	<td>+</td>
	<td>++</td>
	<td>+++</td>
	<td colspan="3"/>	
  </tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">6</td>
<td class="bordered"><xsl:value-of select="$q6Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q6"/>
</xsl:call-template>
<td class="odd inverseLabel">6</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">6</td>
<td class="bordered"><xsl:value-of select="$q6pre_Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q6_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">6</td>
</tr>
  <tr>
    <td colspan="4" class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
</td>
	<td>---</td>
	<td>--</td>
	<td>-</td>
	<td>+</td>
	<td>++</td>
	<td>+++</td>
	<td colspan="3"/>	
  </tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">8</td>
<td class="bordered"><xsl:value-of select="$q8Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q8"/>
</xsl:call-template>
<td class="odd inverseLabel">8</td>
</tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">10</td>
<td class="bordered"><xsl:value-of select="$q10Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q10"/>
</xsl:call-template>
<td class="odd inverseLabel">10</td>
</tr>
<tr>
<td colspan="2" align="right" class="pretest inverseLabel">8/10</td>
<td class="bordered"><xsl:value-of select="$q10pre_Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q10_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">8/10</td>
</tr>
  <tr>
    <td colspan="4" class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
</td>
	<td>---</td>
	<td>--</td>
	<td>-</td>
	<td>+</td>
	<td>++</td>
	<td>+++</td>
	<td colspan="3"/>	
  </tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">11</td>
<td class="bordered"><xsl:value-of select="$q11Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes_reversed">
	<xsl:with-param name="question" select="q11"/>
</xsl:call-template>
<td class="odd inverseLabel">11</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">11</td>
<td class="bordered"><xsl:value-of select="$why1Lbl"/><xsl:call-template name="value_checkbox_reverse"><xsl:with-param name="question" select="q11"/></xsl:call-template><xsl:value-of select="$why2Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q11_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">11</td>
</tr>
  <tr>
    <td colspan="4" class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
</td>
	<td>---</td>
	<td>--</td>
	<td>-</td>
	<td>+</td>
	<td>++</td>
	<td>+++</td>
	<td colspan="3"/>	
  </tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">13</td>
<td class="bordered"><xsl:value-of select="$q13Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes_reversed">
	<xsl:with-param name="question" select="q13"/>
</xsl:call-template>
<td class="odd inverseLabel">13</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">13</td>
<td class="bordered"><xsl:value-of select="$q13pre_Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q13_1_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">13</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">13</td>
<td class="bordered"><xsl:value-of select="$why1Lbl"/><xsl:call-template name="value_checkbox_reverse"><xsl:with-param name="question" select="q13"/></xsl:call-template><xsl:value-of select="$why2Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q13_2_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">13</td>
</tr>
  <tr>
    <td colspan="4" class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
</td>
	<td>---</td>
	<td>--</td>
	<td>-</td>
	<td>+</td>
	<td>++</td>
	<td>+++</td>
	<td colspan="3"/>	
  </tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">21</td>
<td class="bordered"><xsl:value-of select="$q21Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q21"/>
</xsl:call-template>
<td class="odd inverseLabel">21</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">21</td>
<td class="bordered"><xsl:value-of select="$why1Lbl"/><xsl:call-template name="value_checkbox"><xsl:with-param name="question" select="q5"/></xsl:call-template><xsl:value-of select="$why2Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q21_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">21</td>
</tr>
  <tr>
    <td colspan="4" class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
</td>
	<td>---</td>
	<td>--</td>
	<td>-</td>
	<td>+</td>
	<td>++</td>
	<td>+++</td>
	<td colspan="3"/>	
  </tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">29</td>
<td class="bordered"><xsl:value-of select="$q29Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q29"/>
</xsl:call-template>
<td class="odd inverseLabel">29</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">29</td>
<td class="bordered"><xsl:value-of select="$why1Lbl"/><xsl:call-template name="value_checkbox"><xsl:with-param name="question" select="q29"/></xsl:call-template><xsl:value-of select="$why2Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q29_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">29</td>
</tr>
  <tr>
    <td colspan="4" class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
</td>
	<td>---</td>
	<td>--</td>
	<td>-</td>
	<td>+</td>
	<td>++</td>
	<td>+++</td>
	<td colspan="3"/>	
  </tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">30</td>
<td class="bordered"><xsl:value-of select="$q30Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q30"/>
</xsl:call-template>
<td class="odd inverseLabel">30</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">30</td>
<td class="bordered"><xsl:value-of select="$ownLbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q30_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">30</td>
</tr>
  <tr>
    <td colspan="4" class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
</td>
	<td>---</td>
	<td>--</td>
	<td>-</td>
	<td>+</td>
	<td>++</td>
	<td>+++</td>
	<td colspan="3"/>	
  </tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">31</td>
<td class="bordered"><xsl:value-of select="$q31Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q31"/>
</xsl:call-template>
<td class="odd inverseLabel">31</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">31</td>
<td class="bordered"><xsl:value-of select="$why1Lbl"/><xsl:call-template name="value_checkbox"><xsl:with-param name="question" select="q31"/></xsl:call-template><xsl:value-of select="$why2Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q31_1_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">31</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">31</td>
<td class="bordered"><xsl:value-of select="$q31pre_Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q31_2_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">31</td>
</tr>
  <tr>
    <td colspan="4" class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
</td>
	<td>---</td>
	<td>--</td>
	<td>-</td>
	<td>+</td>
	<td>++</td>
	<td>+++</td>
	<td colspan="3"/>	
  </tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">33</td>
<td class="bordered"><xsl:value-of select="$q33Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q33"/>
</xsl:call-template>
<td class="odd inverseLabel">33</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">33</td>
<td class="bordered"><xsl:value-of select="$why1Lbl"/><xsl:call-template name="value_checkbox"><xsl:with-param name="question" select="q33"/></xsl:call-template><xsl:value-of select="$why2Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q33_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">33</td>
</tr>
  <tr>
    <td colspan="4" class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
</td>
	<td>---</td>
	<td>--</td>
	<td>-</td>
	<td>+</td>
	<td>++</td>
	<td>+++</td>
	<td colspan="3"/>	
  </tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">35</td>
<td><xsl:value-of select="$q35Lbl"/></td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd" colspan="8"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">35</td>
</tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">a</td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:value-of select="$q35aLbl"/></td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q35_1"/>
</xsl:call-template>
<td class="odd inverseLabel">a</td>
</tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">b</td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:value-of select="$q35bLbl"/></td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q35_2"/>
</xsl:call-template>
<td class="odd inverseLabel">b</td>
</tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">c</td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:value-of select="$q35cLbl"/></td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q35_3"/>
</xsl:call-template>
<td class="odd inverseLabel">c</td>
</tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">d</td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:value-of select="$q35dLbl"/></td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q35_4"/>
</xsl:call-template>
<td class="odd inverseLabel">d</td>
</tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">e</td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:value-of select="$q35eLbl"/></td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q35_5"/>
</xsl:call-template>
<td class="odd inverseLabel">e</td>
</tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">f</td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:value-of select="$q35fLbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q35_6"/>
</xsl:call-template>
<td class="odd inverseLabel">f</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">35f</td>
<td class="bordered"><xsl:value-of select="$q35fpre_Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q35f_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">35f</td>
</tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">f</td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:value-of select="$q35gLbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q35_7"/>
</xsl:call-template>
<td class="odd inverseLabel">f</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">35</td>
<td class="bordered"><xsl:value-of select="$understandLbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q35_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">35</td>
</tr>
  <tr>
    <td colspan="4" class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
</td>
	<td>---</td>
	<td>--</td>
	<td>-</td>
	<td>+</td>
	<td>++</td>
	<td>+++</td>
	<td colspan="3"/>	
  </tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">36</td>
<td><xsl:value-of select="$q36Lbl"/></td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd" colspan="8"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">36</td>
</tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">a</td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:value-of select="$q36aLbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q36_1"/>
</xsl:call-template>
<td class="odd inverseLabel">a</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">36a</td>
<td class="bordered"><xsl:value-of select="$ownLbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q36a_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">36a</td>
</tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">b</td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:value-of select="$q36bLbl"/></td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q36_2"/>
</xsl:call-template>
<td class="odd inverseLabel">b</td>
</tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">c</td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:value-of select="$q36cLbl"/></td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q36_3"/>
</xsl:call-template>
<td class="odd inverseLabel">c</td>
</tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">d</td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:value-of select="$q36dLbl"/></td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q36_4"/>
</xsl:call-template>
<td class="odd inverseLabel">d</td>
</tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">e</td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:value-of select="$q36eLbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q36_5"/>
</xsl:call-template>
<td class="odd inverseLabel">e</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">36e</td>
<td class="bordered"><xsl:value-of select="$ownLbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q36e_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">36e</td>
</tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">f</td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:value-of select="$q36fLbl"/></td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q36_6"/>
</xsl:call-template>
<td class="odd inverseLabel">f</td>
</tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">g</td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:value-of select="$q36gLbl"/></td>
<td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q36_7"/>
</xsl:call-template>
<td class="odd inverseLabel">g</td>
</tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">h</td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text><xsl:value-of select="$q36hLbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<xsl:call-template name="checkboxes">
	<xsl:with-param name="question" select="q36_8"/>
</xsl:call-template>
<td class="odd inverseLabel">h</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">36</td>
<td class="bordered"><xsl:value-of select="$understandLbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q36_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">36</td>
</tr>
<tr>
<td colspan="2" align="right" class="pretest inverseLabel">35/36</td>
<td class="bordered"><xsl:value-of select="$q36pre2_Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q36_pre2" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">35/36</td>
</tr>
  <tr>
    <td colspan="13" class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
  </tr>
<tr>
	<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
	<td class="odd inverseLabel">37</td>
	<td class="bordered"><xsl:value-of select="$q37Lbl"/></td>
	<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
	<td class="odd" colspan="8">
		<select name="q37" disabled="disabled">
		<option value="-1"><xsl:if test="q37 = -1"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>--</option>
		<option value="0"><xsl:if test="q37 = 0"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>0</option>
		<option value="1"><xsl:if test="q37 = 1"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>1-3</option>
		<option value="2"><xsl:if test="q37 = 2"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>4-10</option>
		<option value="3"><xsl:if test="q37 = 3"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>11-50</option>
		<option value="4"><xsl:if test="q37 = 4"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>51-100</option>
		<option value="5"><xsl:if test="q37 = 5"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>101-200</option>
		<option value="6"><xsl:if test="q37 = 6"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>201-500</option>
		<option value="7"><xsl:if test="q37 = 7"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>501-1'000</option>
		<option value="8"><xsl:if test="q37 = 8"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>1'001-2'000</option>
		<option value="9"><xsl:if test="q37 = 9"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>2'001-5'000</option>
		<option value="10"><xsl:if test="q37 = 10"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>5'001-10'000</option>
		<option value="11"><xsl:if test="q37 = 11"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>more then 10'000</option>
		</select>
	</td>
	<td class="odd inverseLabel">37</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">37</td>
<td class="bordered"><xsl:value-of select="$q37pre_Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q37_1_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">37</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">37</td>
<td class="bordered"><xsl:value-of select="$guessLbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q37_2_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">37</td>
</tr>
  <tr>
    <td colspan="13" class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
  </tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">39</td>
<td class="bordered"><xsl:value-of select="$q38Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd" colspan="3"><input type="text" name="q39" size="7" maxsize="20" disabled="disabled"><xsl:attribute name="value"><xsl:if test="not(q39 = -1)"><xsl:value-of select="q39"/></xsl:if></xsl:attribute></input></td>
<td class="odd" colspan="5"><xsl:value-of select="$hoursLbl"/></td>
<td class="odd inverseLabel">39</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">39</td>
<td class="bordered"><xsl:value-of select="$why1Lbl"/><xsl:if test="not(q39 = -1)"><xsl:value-of select="q39"/></xsl:if><xsl:value-of select="$why2Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q38_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">39</td>
</tr>
  <tr>
    <td colspan="13" class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
  </tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">40</td>
<td class="bordered"><xsl:value-of select="$q39Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd" colspan="3">
<select name="q40" disabled="disabled">
<option value="-1"><xsl:if test="q40 = -1"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>--</option>
<option value="1"><xsl:if test="q40 = 1"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>0-10</option>
<option value="2"><xsl:if test="q40 = 2"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>11-20</option>
<option value="3"><xsl:if test="q40 = 3"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>21-30</option>
<option value="4"><xsl:if test="q40 = 4"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>31-40</option>
<option value="5"><xsl:if test="q40 = 5"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>41-50</option>
<option value="6"><xsl:if test="q40 = 6"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>51-60</option>
<option value="7"><xsl:if test="q40 = 7"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>61-70</option>
<option value="8"><xsl:if test="q40 = 8"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>71-80</option>
<option value="9"><xsl:if test="q40 = 9"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>81-90</option>
<option value="10"><xsl:if test="q40 = 10"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>91-100</option>
</select>
</td>
<td class="odd" colspan="5">%</td>
<td class="odd inverseLabel">40</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">40</td>
<td class="bordered"><xsl:value-of select="$ownLbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q39_1_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">40</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">40</td>
<td class="bordered"><xsl:value-of select="$difficultLbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q39_2_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">40</td>
</tr>
  <tr>
    <td colspan="13" class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
  </tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">41</td>
<td class="bordered"><xsl:value-of select="$q40Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd" colspan="3">
<select name="q40" disabled="disabled">
<option value="-1"><xsl:if test="q41 = -1"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>--</option>
<option value="1"><xsl:if test="q41 = 1"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>0-10</option>
<option value="2"><xsl:if test="q41 = 2"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>11-20</option>
<option value="3"><xsl:if test="q41 = 3"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>21-30</option>
<option value="4"><xsl:if test="q41 = 4"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>31-40</option>
<option value="5"><xsl:if test="q41 = 5"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>41-50</option>
<option value="6"><xsl:if test="q41 = 6"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>51-60</option>
<option value="7"><xsl:if test="q41 = 7"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>61-70</option>
<option value="8"><xsl:if test="q41 = 8"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>71-80</option>
<option value="9"><xsl:if test="q41 = 9"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>81-90</option>
<option value="10"><xsl:if test="q41 = 10"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>91-100</option>
</select>
</td>
<td class="odd" colspan="5">%</td>
<td class="odd inverseLabel">41</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">41</td>
<td class="bordered"><xsl:value-of select="$ownLbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q40_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">41</td>
</tr>
  <tr>
    <td colspan="13" class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
  </tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">46</td>
<td class="bordered"><xsl:value-of select="$q46Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd" colspan="8">
<select name="q46" disabled="disabled">
<option value="-1"><xsl:if test="q46 = -1"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>--</option>
<option value="1"><xsl:if test="q46 = 1"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>yes</option>
<option value="2"><xsl:if test="q46 = 2"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>no</option>
</select>
</td>
<td class="odd inverseLabel">46</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">46</td>
<td class="bordered"><xsl:value-of select="$ownLbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q46_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">46</td>
</tr>
  <tr>
    <td colspan="13" class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
  </tr>
<tr>
<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd inverseLabel">47</td>
<td class="bordered"><xsl:value-of select="$q47Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="odd" colspan="8">
<select name="q47" disabled="disabled">
<option value="-1"><xsl:if test="q47 = -1"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>--</option>
<option value="1"><xsl:if test="q47 = 1"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>1</option>
<option value="2"><xsl:if test="q47 = 2"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>2</option>
<option value="3"><xsl:if test="q47 = 3"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>3</option>
<option value="4"><xsl:if test="q47 = 4"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>4</option>
<option value="5"><xsl:if test="q47 = 5"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>5</option>
<option value="6"><xsl:if test="q47 = 6"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if>more then 5</option>
</select>
</td>
<td class="odd inverseLabel">47</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">47</td>
<td class="bordered"><xsl:value-of select="$q47pre_Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q47_pre" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">47</td>
</tr>

  <tr>
    <td colspan="2"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
    <td class="bordered" colspan="2"><h2><xsl:value-of select="$finishLbl"/></h2></td>
    <td colspan="8"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
    <td><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
  </tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">pre 1</td>
<td class="bordered"><xsl:value-of select="$pre1Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q_pre_1" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">pre 1</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">pre 2</td>
<td class="bordered"><xsl:value-of select="$pre2Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q_pre_2" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">pre 2</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">pre 3</td>
<td class="bordered"><xsl:value-of select="$pre3Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q_pre_3" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">pre 3</td>
</tr>
<tr>
<td class="pretest"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest inverseLabel">pre 4</td>
<td class="bordered"><xsl:value-of select="$pre4Lbl"/></td>
<td class="bordered"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
<td class="pretest" colspan="8">
<textarea class="pretest" name="q_pre_4" cols="40" rows="3"></textarea>
</td>
<td class="pretest inverseLabel">pre 4</td>
</tr>
  <tr>
    <td colspan="13"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
  </tr>
  <tr>
    <td colspan="2"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
    <td colspan="11">
	<input type="submit" value="Speichern">
		<xsl:attribute name="value"><xsl:value-of select="$ButtonLbl"/></xsl:attribute>
	</input></td>
  </tr>
</table>

</xsl:template>

<xsl:template name="checkboxes">
	<xsl:param name="question"/>
	<td class="odd">
		<input type="radio" value="1" disabled="disabled" title="---">
			<xsl:if test="$question = 1">
				<xsl:attribute name="checked">checked</xsl:attribute>
			</xsl:if>
		</input>
	</td>
	<td class="odd">
		<input type="radio" value="2" disabled="disabled" title="--">
			<xsl:if test="$question = 2">
				<xsl:attribute name="checked">checked</xsl:attribute>
			</xsl:if>
		</input>
	</td>
	<td class="odd">
		<input type="radio"  value="3" disabled="disabled" title="-">
			<xsl:if test="$question = 3">
				<xsl:attribute name="checked">checked</xsl:attribute>
			</xsl:if>
		</input>
	</td>
	<td class="odd">
		<input type="radio" value="4" disabled="disabled" title="+">
			<xsl:if test="$question = 4">
				<xsl:attribute name="checked">checked</xsl:attribute>
			</xsl:if>
		</input>
	</td>
	<td class="odd">
		<input type="radio" value="5" disabled="disabled" title="++">
			<xsl:if test="$question = 5">
				<xsl:attribute name="checked">checked</xsl:attribute>
			</xsl:if>
		</input>
	</td>
	<td class="odd">
		<input type="radio" value="6" disabled="disabled" title="+++">
			<xsl:if test="$question = 6">
				<xsl:attribute name="checked">checked</xsl:attribute>
			</xsl:if>
		</input>
	</td>
	<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
	<td class="odd">
		<input type="radio" value="-1" disabled="disabled">
			<xsl:attribute name="title"><xsl:value-of select="$dontKnow"></xsl:value-of></xsl:attribute>
			<xsl:if test="$question = -1">
				<xsl:attribute name="checked">checked</xsl:attribute>
			</xsl:if>
		</input>
	</td>
</xsl:template>


<xsl:template name="checkboxes_reversed">
	<xsl:param name="question"/>
	<td class="odd">
		<input type="radio" value="6" disabled="disabled" title="---">
			<xsl:if test="$question = 6">
				<xsl:attribute name="checked">checked</xsl:attribute>
			</xsl:if>
		</input>
	</td>
	<td class="odd">
		<input type="radio" value="5" disabled="disabled" title="--">
			<xsl:if test="$question = 5">
				<xsl:attribute name="checked">checked</xsl:attribute>
			</xsl:if>
		</input>
	</td>
	<td class="odd">
		<input type="radio"  value="4" disabled="disabled" title="-">
			<xsl:if test="$question = 4">
				<xsl:attribute name="checked">checked</xsl:attribute>
			</xsl:if>
		</input>
	</td>
	<td class="odd">
		<input type="radio" value="3" disabled="disabled" title="+">
			<xsl:if test="$question = 3">
				<xsl:attribute name="checked">checked</xsl:attribute>
			</xsl:if>
		</input>
	</td>
	<td class="odd">
		<input type="radio" value="2" disabled="disabled" title="++">
			<xsl:if test="$question = 2">
				<xsl:attribute name="checked">checked</xsl:attribute>
			</xsl:if>
		</input>
	</td>
	<td class="odd">
		<input type="radio" value="1" disabled="disabled" title="+++">
			<xsl:if test="$question = 1">
				<xsl:attribute name="checked">checked</xsl:attribute>
			</xsl:if>
		</input>
	</td>
	<td class="odd"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
	<td class="odd">
		<input type="radio" value="-1" disabled="disabled">
			<xsl:attribute name="title"><xsl:value-of select="$dontKnow"></xsl:value-of></xsl:attribute>
			<xsl:if test="$question = -1">
				<xsl:attribute name="checked">checked</xsl:attribute>
			</xsl:if>
		</input>
	</td>
</xsl:template>

<xsl:template name="value_checkbox">
	<xsl:param name="question"/>
	<xsl:choose>
		<xsl:when test="$question = 1">---</xsl:when>
		<xsl:when test="$question = 2">--</xsl:when>
		<xsl:when test="$question = 3">-</xsl:when>
		<xsl:when test="$question = 4">+</xsl:when>
		<xsl:when test="$question = 5">++</xsl:when>
		<xsl:when test="$question = 6">+++</xsl:when>
		<xsl:otherwise><xsl:value-of select="$dontKnow"/></xsl:otherwise>
	</xsl:choose>
</xsl:template>

<xsl:template name="value_checkbox_reverse">
	<xsl:param name="question"/>
	<xsl:choose>
		<xsl:when test="$question = 6">---</xsl:when>
		<xsl:when test="$question = 5">--</xsl:when>
		<xsl:when test="$question = 4">-</xsl:when>
		<xsl:when test="$question = 3">+</xsl:when>
		<xsl:when test="$question = 2">++</xsl:when>
		<xsl:when test="$question = 1">+++</xsl:when>
		<xsl:otherwise><xsl:value-of select="$dontKnow"/></xsl:otherwise>
	</xsl:choose>
</xsl:template>

</xsl:stylesheet>
