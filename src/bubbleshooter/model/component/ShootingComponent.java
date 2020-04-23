package bubbleshooter.model.component;

public class ShootingComponent extends AbstractComponent {

    public ShootingComponent() {
        this.setType(ComponentType.SHOOTINGCOMPONENT);
    }

    @Override
    public final void update(final double elapsed) {
        if (!this.getContainer().getDirection().equals(this.getContainer().getPosition())) {
            this.moveBubble(elapsed);
          }
    }

    private void moveBubble(final double elapsed) {
        super.getContainer().setPosition(super.getContainer().getPosition().add(this.getContainer().getDirection().multiply(elapsed)));
    }
}
