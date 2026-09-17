var elt = document.getElementById('calculator');
var calculator = Desmos.GraphingCalculator(elt, { accentColor: '#000000' });
calculator.setExpression({ id: '1', latex: 'y=xx' })
calculator.setExpression({ id: '2', latex: 'y=xxx' })
calculator.setExpression({ id: '3', latex: 'a=0', sliderBounds: { min: '0', max: '5', step: '0.1' }, playing: true, secret: true })

/**
 * @returns {string}
 */
function rainBow() {

}
