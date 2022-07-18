package com.basics;
/**
 * 
 * @author rajasekhar
 *1. Using id == use # symbol
 *              syntax: htmltag#id or #id
 *              Example: ul#categories  or #categories
 *              
 * 2. Using class  == use . symbol
 *  			syntax: htmltag.classname, htmltag.c1.c2.c3 etc / .classname.classname2.classname3
 *              Example; input.form-control.private-form__control.login-email
 *                       .form-control.private-form__control.login-email
 *                       
 *  using attribute == tagname[attribute='value']
 *  			Example: div[id='test']
 *  
 *  using multiple attribute == tagname[attribute='value'][attribute2='value']
 *  contains == * symbol  --> ex: input[id*='user']
 *  
 *  Starts-with == ^ symbol  --> ex: input[id^='user']
 *  Ends with == $ symbol  --> input[id$='name']
 *  
 *  parent>childtag
 *
 *  ul#categories>li  -- Here it will point all the child tags which are with li under ul tag.
 *
 * first-of-type in css selector
 * ul#categories>li:first-of-type   -- Here it will select only first element which present in li tag under parent ul tag
 *
 * last-of-type in css selector
 * ul#categories>li:last-of-type  -- Here it will select only last element which present in li tag under parent ul tag.
 *
 * nth-of-type in css-selector
 * ul#categories>li:nth-of-type(3)   -- Here it will select only 3rd element which present in li tag under parent ul tag.
 *
 * Sibling:
 * xpath for sibling: //div[@class='private-form__control-wrapper']//following-sibling::div -- It will point to siling point which present in parent div tag
 * CSS Sibling:  div.private-form__control-wrapper+div  -- It will point sibling tags
 *
 *
 */
public class CSSConcept {

	public static void main(String[] args) {
		

	}

}
