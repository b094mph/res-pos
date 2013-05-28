/* fixed-table-header
 * courtesy of flaviaza - https://gist.github.com/flaviaza/3763015
 */

(function($) {
	 
	$.fn.fixedHeader = function () {
	 
	 return this.each( function() {
	  var o = $(this)
	    , nhead = o.closest('.fixed-table');
	  
	  var $head = $('thead.header', o);
	  
	  $head.clone().removeClass('header').addClass('header-copy header-fixed').appendTo(nhead);
	  var ww = [];
	  o.find('thead.header > tr:first > th').each(function (i, h){
	    ww.push($(h).width());
	  });
	  $.each(ww, function (i, w){
	    nhead.find('thead.header > tr > th:eq('+i+'), thead.header-copy > tr > th:eq('+i+')').css({width: w});
	  });
	 
	  nhead.find('thead.header-copy').css({ margin:'0 auto',
	                                    width: o.width()});
	 });
	};
	 
})(jQuery);