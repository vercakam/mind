import QtQuick 2.4
import QtQuick.Controls 2.5
import ".."

MenuPage {
    id: foodContactPage
    title: qsTrId("food-contact")

    ScrollView {
        anchors.fill: parent
        contentWidth: -1
        clip: true
    Description {
        text: qsTrId("food-contact-text")
        font.pointSize: 30
    }
    }
}
